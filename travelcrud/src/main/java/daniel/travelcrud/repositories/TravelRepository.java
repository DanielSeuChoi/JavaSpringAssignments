package daniel.travelcrud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import daniel.travelcrud.models.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long> {
    List<Travel> findAll();
}
