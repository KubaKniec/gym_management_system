package pl.edu.pjatk.gym_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.gym_management_system.security.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
