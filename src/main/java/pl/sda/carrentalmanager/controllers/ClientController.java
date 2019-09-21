package pl.sda.carrentalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carrentalmanager.models.Client;
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
        modelAndView.addObject("clients", clientService.findAll());
        return modelAndView;
    }

    @GetMapping("/client/form")
    public ModelAndView ClientFormView() {
        ModelAndView modelAndView = new ModelAndView("clientForm");
        modelAndView.addObject("client", new Client());
        return modelAndView;
    }

    @PostMapping("/clients/add")
    public String ModelAndView(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:" + client.getId();
    }

    @GetMapping("/client/update/{id}")
    public ModelAndView ClientUpdateView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("clientForm");
        Client foundClient = clientService.findById(id);
        modelAndView.addObject("client", foundClient);
        modelAndView.addObject("update", true);
        return modelAndView;
    }

    @GetMapping("/clients/{id}")
    public ModelAndView ClientDetailView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("clientDetails");
        Client client = clientService.findById(id);
        modelAndView.addObject("client", client);
        return modelAndView;
    }
}