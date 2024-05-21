package se.iths.userserviceemi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.userserviceemi.dto.UserDTO;
import se.iths.userserviceemi.entity.User;
import se.iths.userserviceemi.service.UserService;

import java.util.List;
import java.util.Optional;
//@CrossOrigin(origins = "http://localhost:8080/", maxAge = 60, allowedHeaders = {"userToken"})
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userID}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String userID) {
        return userService.getUser(userID)
                .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with that ID found"));
    }



    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{userID}")
    public ResponseEntity<String> updateUser(@PathVariable String userID, @Valid @RequestBody UserDTO userDTO) {
        userService.updateUser(userID, userDTO);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }


}
