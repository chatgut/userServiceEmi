package se.iths.userserviceemi.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.iths.userserviceemi.dto.UserDTO;
import se.iths.userserviceemi.entity.User;
import se.iths.userserviceemi.mapper.UserMapper;
import se.iths.userserviceemi.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> UserMapper.mapToUserDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }


    public void createOrUpdateUser(UserDTO userDTO, String userID) {
        Optional<User> existingUserOptional = userRepository.findByUserID(userID);
        if (existingUserOptional.isPresent()) {
            updateUser(existingUserOptional.get(), userDTO);
        } else {
            createUser(userDTO, userID);
        }
    }

    private void updateUser(User existingUser, UserDTO userDTO) {
        String usernameExistingUser = existingUser.getUsername();
        String nameDTO = userDTO.getName();
        if (userRepository.existsByUsername(userDTO.getName()) && !usernameExistingUser.equals(nameDTO)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        } else {
            existingUser.setUsername(nameDTO);
            existingUser.setImageLink(userDTO.getImageLink());
            userRepository.save(existingUser);
        }
    }

    private void createUser(UserDTO userDTO, String userID) {
        User newUser = new User();
        newUser.setUsername(userDTO.getName());
        newUser.setImageLink(userDTO.getImageLink());
        newUser.setUserID(userID);
        userRepository.save(newUser);

    }

    public Optional<UserDTO> getUserByUserID(String userID) {
        return getUserByHeader(userID)
                .map(user -> UserMapper.mapToUserDTO(user, new UserDTO()));
    }

    private Optional<User> getUserByHeader(String userID) {
        return userRepository.findByUserID(userID);
    }

}

