package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.service.TrainerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/trainer", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    @GetMapping //dziala
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return ResponseEntity.ok(trainerService.findAllTrainers());
    }

    @PostMapping //dziala
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.createTrainer(trainer));
    }

    //todo naprawic bo wyswietla wszystkich a nie tego z podanym id
    @GetMapping("/by-path/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    //todo naprawic, blad 500, ZNOW !!!!
    @GetMapping("/{name}/{lastName}")
    public ResponseEntity<Trainer> getTrainerByFirstNameAndLastName(@PathVariable String name, @PathVariable String lastName) {
        return ResponseEntity.ok(trainerService.findTrainerByFirstNameAndLastName(name, lastName));
    }

    @GetMapping("/by-request")  //PRZETESTOWAC
    public ResponseEntity<Trainer> getTrainerByIdRequestParam(@RequestParam Long id) {
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @DeleteMapping  //dziala
    public ResponseEntity<Long> deleteTrainerById(@RequestParam Long id) {
        trainerService.deleteTrainerById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainer(trainer));
    }
}
