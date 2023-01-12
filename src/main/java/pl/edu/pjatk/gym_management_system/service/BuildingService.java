package pl.edu.pjatk.gym_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.repository.BuildingRepository;

import java.util.List;

//crud
//create
//read
//update
//delete

@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public List<Building> findAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingById(Long id) {
        return buildingRepository.findById(id).orElse(null);
    }

    public void deleteBuildingById(Long id) {
        buildingRepository.deleteById(id);
    }

    public Building updateBuilding(Building building) {
        return buildingRepository.save(building);
    }
}
