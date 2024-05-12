package se.iths.userserviceemi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import se.iths.userserviceemi.dto.UserDTO;
import se.iths.userserviceemi.entity.User;
import se.iths.userserviceemi.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }
}
