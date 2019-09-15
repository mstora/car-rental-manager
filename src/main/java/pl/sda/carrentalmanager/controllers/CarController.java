package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/cars/delete/{id}")
    public String carDeleteById(@PathVariable String id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("/cars/form")
    public ModelAndView carFormView() {
        ModelAndView modelAndView = new ModelAndView("carForm");
        modelAndView.addObject("car", new Car());
        return modelAndView;
    }

    @GetMapping("/cars/update/{id}")
    public ModelAndView carUpdateView(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("carForm");
        Car foundCar = carService.findById(id);
        modelAndView.addObject("car", foundCar);
        modelAndView.addObject("update", true);
        return modelAndView;
    }

    @PostMapping("/cars/add")
    public String carAdd(@ModelAttribute Car car) {
        carService.save(car);
        return "redirect:" + car.getId();
    }
    @PostMapping("/cars/update")
    public String carUpdateView(@ModelAttribute Car car) {
        carService.save(car);
        return "redirect:" + car.getId();
    }
}
