package se.iths.userserviceemi.mapper;

import org.springframework.stereotype.Component;
import se.iths.userserviceemi.dto.UserDTO;
import se.iths.userserviceemi.entity.User;
@Component
public class UserMapper {


    public static UserDTO mapToUserDTO(User user, UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserID(user.getUserID());
        userDTO.setImageUrl(user.getImageUrl());
        userDTO.setNumberOfMessages(user.getNumberOfMessages());
        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO, User user) {
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserID(userDTO.getUserID());
        user.setImageUrl(userDTO.getImageUrl());
        user.setNumberOfMessages(userDTO.getNumberOfMessages());
        return user;
    }

}
