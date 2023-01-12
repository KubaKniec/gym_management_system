package pl.edu.pjatk.gym_management_system.service;

//crud
//create
//read
//update
//delete

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.repository.EquipmentRepository;

@Service
public class EquipmentService {
    EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

//    public createEquipment
}
