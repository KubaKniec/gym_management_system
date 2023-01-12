package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.gym_management_system.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByFirstNameAndLastName(String firstName, String lastName);
}
