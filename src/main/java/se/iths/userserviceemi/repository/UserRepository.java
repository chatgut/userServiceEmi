package se.iths.userserviceemi.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.userserviceemi.entity.User;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {

}
