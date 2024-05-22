package se.iths.userserviceemi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    private String name;

    private String imageLink;

    private int numberOfMessages;
}
