package pl.sda.carrentalmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carrentalmanager.models.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
