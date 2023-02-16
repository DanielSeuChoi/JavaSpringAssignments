package daniel.travelcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daniel.travelcrud.models.Travel;
import daniel.travelcrud.repositories.TravelRepository;

@Service
public class TravelService {
    @Autowired
    TravelRepository travelRepository;

    public void createTravel(Travel travel) {
        travelRepository.save(travel);
    }

    public List<Travel> allTravels() {
        return travelRepository.findAll();
    }

    public Travel getOneTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        return optionalTravel.orElse(null);
    }

    public void updateTravel(Travel travel) {
        travelRepository.save(travel);
    }

    public void deleteTravel(Travel travel) {
        travelRepository.delete(travel);
    }
}
