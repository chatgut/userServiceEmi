package se.iths.userserviceemi.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public Optional<UserDTO> getUser(Long id) {
        return userRepository.findById(id)
                .map(user -> UserMapper.mapToUserDTO(user, new UserDTO()));
    }

    public void createUser(UserDTO userDTO) {
        if (userRepository.existsByUserName(userDTO.getUserName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        User user = UserMapper.mapToUser(userDTO, new User());
        userRepository.save(user);
    }


    public void updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        existingUser.setUserName(userDTO.getUserName());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setUserToken(userDTO.getUserToken());
        existingUser.setImageUrl(userDTO.getImageUrl());
        existingUser.setNumberOfMessages(userDTO.getNumberOfMessages());

        userRepository.save(existingUser);
    }

}
