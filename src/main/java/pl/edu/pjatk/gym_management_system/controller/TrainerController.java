package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.service.TrainerService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/trainer", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;
    Logger log = Logger.getLogger(TrainerController.class.getName());

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        log.info("Get all trainers");
        return ResponseEntity.ok(trainerService.findAllTrainers());
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        log.info("Create trainer");
        return ResponseEntity.ok(trainerService.createTrainer(trainer));
    }

    @GetMapping("/by-path/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        log.info("Get trainer by id");
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @GetMapping("/{name}/{lastName}")
    public ResponseEntity<Trainer> getTrainerByFirstNameAndLastName(@PathVariable String name, @PathVariable String lastName) {
        log.info("Get trainer by name and lastname");
        return ResponseEntity.ok(trainerService.findTrainerByFirstNameAndLastName(name, lastName));
    }

    @GetMapping("/by-request")
    public ResponseEntity<Trainer> getTrainerByIdRequestParam(@RequestParam Long id) {
        log.info("Get trainer by id");
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteTrainerById(@RequestParam Long id) {
        log.info("Delete trainer");
        trainerService.deleteTrainerById(id);
        return ResponseEntity.ok(id);
    }
    @PutMapping
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) {
        log.info("Update trainer");
        return ResponseEntity.ok(trainerService.updateTrainer(trainer));
    }
}
