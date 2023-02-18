package daniel.bookclub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import daniel.bookclub.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);
}
