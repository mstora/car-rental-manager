package pl.sda.carrentalmanager.services;

import org.springframework.stereotype.Service;
import pl.sda.carrentalmanager.models.Car;
import pl.sda.carrentalmanager.models.Rental;
import pl.sda.carrentalmanager.repositories.RentalRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public List<Rental> findAllByCar(Car car) {
         List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream()
                .filter(rental -> rental.getCar().equals(car))
                .collect(Collectors.toList());

    }
}