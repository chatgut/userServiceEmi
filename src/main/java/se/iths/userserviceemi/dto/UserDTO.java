package se.iths.userserviceemi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    private long id;

    @NotBlank(message = "Username is mandatory")
    private String userName;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    private String imageUrl;

    private String userToken;

    private int numberOfMessages;
}
