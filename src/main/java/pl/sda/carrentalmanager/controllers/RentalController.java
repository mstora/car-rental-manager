package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.services.RentalService;

@Controller
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/rentals")
    public ModelAndView listOfRentals() {
        ModelAndView modelAndView = new ModelAndView("rentals");
        modelAndView.addObject("rentals", rentalService.getAll());
        return modelAndView;
    }
}
