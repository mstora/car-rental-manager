package pl.sda.carrentalmanager.services;

import org.springframework.stereotype.Service;
import pl.sda.carrentalmanager.exceptions.CarNotFoundException;
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
       return carRepository.findAll();
    }

    public Car findById(String id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car with id: " + id + " not found"));
    }

    public void deleteById(String id) {
//        Car car = carRepository.f
    }
}