package se.iths.userserviceemi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.userserviceemi.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUserID(String userID);

    @Query("SELECT u.numberOfMessages FROM User u WHERE u.userID = :userID")
    Integer getNumberOfMessages(String userID);
}
