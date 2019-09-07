package pl.sda.carrentalmanager.services;

import org.springframework.stereotype.Service;
import pl.sda.carrentalmanager.models.Client;
import pl.sda.carrentalmanager.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }


    public List<Client> getAll() {
        return clientRepository.findAll();

    }

}
