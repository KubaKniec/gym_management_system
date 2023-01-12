package pl.edu.pjatk.gym_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Trainer;
import pl.edu.pjatk.gym_management_system.repository.TrainerRepository;

import java.util.List;
import java.util.Optional;

//crud
//create
//read
//update
//delete

@Service
public class TrainerService {
    TrainerRepository trainerRepository;

    @Autowired
    public void TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public List<Trainer> findAllTrainers() {
        return trainerRepository.findAll();
    }

    //todo naprawic bo wyswietla wszystkich a nie tego z podanym id
    public Trainer getTrainerById(Long id) {
        return trainerRepository.getReferenceById(id);
    }

    public void deleteTrainerById(Long id) {
        trainerRepository.deleteById(id);
    }

    public Trainer findTrainerByFirstNameAndLastName(String firstName, String lastName) {
        Optional<Trainer> trainer = trainerRepository.findTrainerByFirstNameAndLastName(firstName, lastName);
        if (trainer.isPresent()) {
            trainer.get();
        }
        throw new IllegalArgumentException();
    }

    //todo update triner

}
