package pl.sda.carrentalmanager.services;

import org.springframework.stereotype.Service;
import pl.sda.carrentalmanager.exceptions.ItemNotFoundException;
import pl.sda.carrentalmanager.models.Car;
import pl.sda.carrentalmanager.repositories.CarRepository;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findByExist(true);
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

    public void save(Car car) {
        carRepository.save(car);
    }

    public List<Car> findByIsDamaged(boolean isDamaged) {
        return carRepository.findByIsDamaged(isDamaged);
    }
    public List<Car> findByIsAvailable(boolean isAvailable) {
        return carRepository.findByIsAvailable(isAvailable);
    }

    public List<Car> findByIsDamagedAndIsAvailableAndExist(boolean isDamaged, boolean isAvailable, boolean exist) {
        return carRepository.findByIsDamagedAndIsAvailableAndExist(isDamaged, isAvailable, exist);
    }
}