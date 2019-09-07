package pl.sda.carrentalmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carrentalmanager.models.Car;

public interface CarRepository extends JpaRepository<Car, String> {
}
