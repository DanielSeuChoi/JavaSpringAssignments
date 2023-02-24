package daniel.validations.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import daniel.validations.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
