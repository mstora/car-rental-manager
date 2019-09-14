package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.models.Rental;
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
        modelAndView.addObject("rentals", rentalService.findAll());
        return modelAndView;
    }

    @GetMapping("/rentals/{id}")
    public ModelAndView carDetailsView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("rentalDetails");
        Rental rental = rentalService.findById(id);
        modelAndView.addObject("rental", rental);

        return modelAndView;
    }
}
