package pl.sda.carrentalmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.models.Car;
import pl.sda.carrentalmanager.models.Rental;
import pl.sda.carrentalmanager.services.CarService;
import pl.sda.carrentalmanager.services.RentalService;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    private final CarService carService;
    private final RentalService rentalService;

    public CarController(CarService carService, RentalService rentalService) {
        this.carService = carService;
        this.rentalService = rentalService;
    }

    @GetMapping("/cars")
    public ModelAndView listOfCars() {
        ModelAndView modelAndView = new ModelAndView("cars");
        modelAndView.addObject("cars", carService.findAll());
        return modelAndView;
    }

    @GetMapping("/cars/{id}")
    public ModelAndView carDetailsView(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("carDetails");
        Optional<Car> car = carService.findById(id);
        List<Rental> rentals = rentalService.findAllByCar(carService.findById(id).get());
        if (car.isPresent()){
            modelAndView.addObject("car", car.get());
            modelAndView.addObject("rentals", rentals);
            return modelAndView;
        } modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}
