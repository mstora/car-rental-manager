package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.models.Car;
import pl.sda.carrentalmanager.services.CarService;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;

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
        Car car = carService.findById(id);
        modelAndView.addObject("car", car);

        return modelAndView;
    }


}
