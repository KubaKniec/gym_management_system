package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.security.User;
import pl.edu.pjatk.gym_management_system.service.UsersService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    Logger log = Logger.getLogger(UsersController.class.getName());

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("Create User");
        return ResponseEntity.ok(usersService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("Get all users");
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteUserById(@RequestParam Long id) {
        log.info("Delete user by id");
        usersService.deleteUserById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        log.info("Update user");
        return ResponseEntity.ok(usersService.updateUser(user));
    }


}
