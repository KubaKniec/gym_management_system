package pl.edu.pjatk.gym_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.security.User;
import pl.edu.pjatk.gym_management_system.security.UserRepository;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
