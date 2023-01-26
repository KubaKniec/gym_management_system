package pl.edu.pjatk.gym_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.repository.TrainerRepository;

import java.util.List;

//crud
//create
//read
//update
//delete

@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public List<Trainer> findAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }

    public void deleteTrainerById(Long id) {
        trainerRepository.deleteById(id);
    }

    public Trainer findTrainerByFirstNameAndLastName(String firstName, String lastName) {
        return trainerRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(IllegalAccessError::new);
    }

    public Trainer updateTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
}
