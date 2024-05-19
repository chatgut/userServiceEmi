package se.iths.userserviceemi.mapper;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;
import se.iths.userserviceemi.dto.UserDTO;
import se.iths.userserviceemi.entity.User;
@Component
public class UserMapper {


    public static UserDTO mapToUserDTO(User user, UserDTO userDTO) {
        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserToken(user.getUserToken());
        userDTO.setImageUrl(user.getImageUrl());
        userDTO.setNumberOfMessages(user.getNumberOfMessages());
        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO, User user) {
        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserToken(userDTO.getUserToken());
        user.setImageUrl(userDTO.getImageUrl());
        user.setNumberOfMessages(userDTO.getNumberOfMessages());
        return user;
    }

}
