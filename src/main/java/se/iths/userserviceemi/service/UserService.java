package se.iths.userserviceemi.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
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


    public UserDTO createOrUpdateUser(UserDTO userDTO, String userID) {
        if (userRepository.findByUserID(userID).isPresent()) {
            return updateUser(userID, userDTO);
        } else {
            return createUser(userDTO, userID);
        }
    }

    private UserDTO updateUser(String userID, UserDTO userDTO) {
        User existingUser = userRepository.findByUserID(userID).get();
        existingUser.setUsername(userDTO.getName());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setImageLink(userDTO.getImageLink());
        userRepository.save(existingUser);
        return UserMapper.mapToUserDTO(existingUser, new UserDTO());
    }

    private UserDTO createUser(UserDTO userDTO, String userID) {
        User newUser = UserMapper.mapToUser(userDTO, new User());
        newUser.setUsername(userDTO.getName());
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setImageLink(userDTO.getImageLink());
        newUser.setUserID(userID);
        userRepository.save(newUser);
        return UserMapper.mapToUserDTO(newUser, new UserDTO());
    }

    public Optional<UserDTO> getUserByUserID(String userID) {
        return getUserByHeader(userID)
                .map(user -> UserMapper.mapToUserDTO(user, new UserDTO()));
    }

    private Optional<User> getUserByHeader(String userID) {
        return userRepository.findByUserID(userID);
    }


    public void incrementMessageCount(String userID) {
        Optional<User> user = userRepository.findByUserID(userID);
        if (user.isPresent()) {
            Integer numberOfMessages = userRepository.getNumberOfMessages(userID);
            if (numberOfMessages != null) {
                int newNumberOfMessages = numberOfMessages + 1;
                user.get().setNumberOfMessages(newNumberOfMessages);
                userRepository.save(user.get());
            }
        }
    }

}

