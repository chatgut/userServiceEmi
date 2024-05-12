package se.iths.userserviceemi.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String userToken;
    private int numberOfMessages;
}
