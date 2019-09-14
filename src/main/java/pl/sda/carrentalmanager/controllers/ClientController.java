package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.services.ClientService;

@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public ModelAndView ListOfClients() {
        ModelAndView modelAndView = new ModelAndView("clients");
        modelAndView.addObject("clients", clientService.getAll());
        return modelAndView;
    }
}