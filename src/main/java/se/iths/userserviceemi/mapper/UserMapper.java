package se.iths.userserviceemi.mapper;

import org.springframework.stereotype.Component;
import se.iths.userserviceemi.dto.UserDTO;
import se.iths.userserviceemi.entity.User;
@Component
public class UserMapper {


    public static UserDTO mapToUserDTO(User user, UserDTO userDTO) {
        userDTO.setName(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setImageLink(user.getImageLink());
        userDTO.setUserID(user.getUserID());
        userDTO.setNumberOfMessages(user.getNumberOfMessages());
        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO, User user) {
        user.setUsername(userDTO.getName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserID(userDTO.getUserID());
        user.setImageLink(userDTO.getImageLink());
        user.setNumberOfMessages(userDTO.getNumberOfMessages());
        return user;
    }

}
