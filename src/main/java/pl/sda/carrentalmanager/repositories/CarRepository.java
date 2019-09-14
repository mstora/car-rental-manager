package pl.sda.carrentalmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carrentalmanager.models.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByExist(boolean exist);
}
