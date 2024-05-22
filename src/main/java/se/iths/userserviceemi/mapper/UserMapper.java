package se.iths.userserviceemi.mapper;

import org.springframework.stereotype.Component;
import se.iths.userserviceemi.dto.UserDTO;
import se.iths.userserviceemi.entity.User;
@Component
public class UserMapper {


    public static UserDTO mapToUserDTO(User user, UserDTO userDTO) {
        userDTO.setName(user.getUsername());
        userDTO.setImageLink(user.getImageUrl());
        userDTO.setNumberOfMessages(user.getNumberOfMessages());
        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO, User user) {
        user.setUsername(userDTO.getName());
        user.setImageUrl(userDTO.getImageLink());
        user.setNumberOfMessages(userDTO.getNumberOfMessages());
        return user;
    }

}
