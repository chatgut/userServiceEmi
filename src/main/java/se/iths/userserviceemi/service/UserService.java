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

    public Optional<UserDTO> getUser(String userID) {
        return userRepository.findByUserID(userID)
                .map(user -> UserMapper.mapToUserDTO(user, new UserDTO()));
    }

    public void createUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        User user = UserMapper.mapToUser(userDTO, new User());
        userRepository.save(user);
    }


    public void updateUser(String userID, UserDTO userDTO) {
        User existingUser = userRepository.findByUserID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setUserID(userDTO.getUserID());
        existingUser.setImageUrl(userDTO.getImageUrl());
        existingUser.setNumberOfMessages(userDTO.getNumberOfMessages());

        userRepository.save(existingUser);
    }

    public UserDTO getUserByUserID(String userID) {
        User user = getUserByHeader(userID);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return UserMapper.mapToUserDTO(user, new UserDTO());
    }

    private User getUserByHeader(String userID) {
        return userRepository.findByUserID(userID).get();
    }
}
