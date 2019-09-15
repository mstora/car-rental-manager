package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.models.Rental;
import pl.sda.carrentalmanager.services.CarService;
import pl.sda.carrentalmanager.services.ClientService;
import pl.sda.carrentalmanager.services.RentalService;

import java.time.LocalDate;

@Controller
public class RentalController {

    private final RentalService rentalService;
    private final CarService carService;
    private final ClientService clientService;

    public RentalController(RentalService rentalService, CarService carService, ClientService clientService) {
        this.rentalService = rentalService;
        this.carService = carService;
        this.clientService = clientService;
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

    @GetMapping("/rental/form")
    public ModelAndView addRentalView() {
        ModelAndView modelAndView = new ModelAndView("rentalForm");
        modelAndView.addObject("cars", carService.findByIsDamagedAndIsAvailableAndExist(false, true, true));
        modelAndView.addObject("clients", clientService.findAll());
        modelAndView.addObject("rental", new Rental());
        modelAndView.addObject("update", false);
        return modelAndView;
    }

    @PostMapping("/rental/add")
    public String addRental(@ModelAttribute Rental rental) {
        rental.setDateOfRental(LocalDate.now());
        rental.getCar().setAvailable(false);
        rentalService.save(rental);
        return "redirect:/rentals";
    }

    @PostMapping("/rental/update")
    public String updateRental(@ModelAttribute Rental rental) {
        rentalService.save(rental);
        return "redirect:/rentals/" + rental.getId();
    }
}