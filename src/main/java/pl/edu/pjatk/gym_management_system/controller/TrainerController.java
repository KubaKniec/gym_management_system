package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.service.TrainerService;

import java.util.List;

@RestController
@RequestMapping("/triner/")
public class TrainerController {

    TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping //dziala
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        return ResponseEntity.ok(trainerService.findAllTrainers());
    }

    @PostMapping //dziala
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
        return ResponseEntity.ok(trainerService.createTrainer(trainer));
    }

    //todo naprawic bo wyswietla wszystkich a nie tego z podanym id
    @GetMapping("{id}")
    public ResponseEntity<Trainer> getTrainerByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    //todo naprawic, blad 500, ZNOW !!!!
    @GetMapping("/{name}/{lastname}")
    public ResponseEntity<Trainer> getTrainerByFirstNameAndLastName(@PathVariable("name") String name, @PathVariable("lastname") String lastname){
        return ResponseEntity.ok(trainerService.findTrainerByFirstNameAndLastName(name, lastname));
    }

    @GetMapping("/get")  //PRZETESTOWAC
    public ResponseEntity<Trainer> getTrainerByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @DeleteMapping  //dziala
    public ResponseEntity<String> deleteTrainerById(@RequestParam("id") Long id){
        trainerService.deleteTrainerById(id);
        return ResponseEntity.ok("ok");
    }

    //todo update triner
}
