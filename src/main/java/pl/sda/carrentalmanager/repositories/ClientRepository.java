package pl.sda.carrentalmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carrentalmanager.models.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
