package se.iths.userserviceemi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import se.iths.userserviceemi.entity.User;
import se.iths.userserviceemi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
