package pl.sda.carrentalmanager.services;

import org.springframework.stereotype.Service;
import pl.sda.carrentalmanager.exceptions.ItemNotFoundException;
import pl.sda.carrentalmanager.models.Car;
import pl.sda.carrentalmanager.repositories.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll().stream().filter(Car::isExist).collect(Collectors.toList());
    }

    public Car findById(String id) {
        return carRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Car with id: " + id + " not found"));
    }

    public void deleteById(String id) {
        Car carTemp = findById(id);
        carTemp.setExist(false);
        carRepository.save(carTemp);
    }
}