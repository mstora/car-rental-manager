package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
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
}
