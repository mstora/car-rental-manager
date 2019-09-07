package pl.sda.carrentalmanager.services;

import org.springframework.stereotype.Service;
import pl.sda.carrentalmanager.models.Rental;
import pl.sda.carrentalmanager.repositories.RentalRepository;

import java.util.List;

@Service
public class RentalService {
    private RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getAll() {
        return rentalRepository.findAll();
    }
}