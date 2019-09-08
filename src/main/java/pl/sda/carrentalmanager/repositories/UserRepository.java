package pl.sda.carrentalmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carrentalmanager.models.User;

public interface UserRepository extends JpaRepository<User, String> {
}
