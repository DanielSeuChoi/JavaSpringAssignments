package daniel.regis.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import daniel.regis.models.User;

public interface RegisRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

}
