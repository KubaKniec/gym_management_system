package pl.edu.pjatk.gym_management_system.service;

//crud
//create
//read
//update
//delete

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Equipment;
import pl.edu.pjatk.gym_management_system.repository.EquipmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> findAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    public void deleteEquipmentById(Long id) {
        equipmentRepository.deleteById(id);
    }

    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }
}
