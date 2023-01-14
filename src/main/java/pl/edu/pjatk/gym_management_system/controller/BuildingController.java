package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Building;
import pl.edu.pjatk.gym_management_system.service.BuildingService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/building", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<Building>> getAllClient() {
        return ResponseEntity.ok(buildingService.findAllBuildings());
    }

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody Building building) {
        return ResponseEntity.ok(buildingService.createBuilding(building));
    }

    @GetMapping("by-path/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable Long id) {
        return ResponseEntity.ok(buildingService.getBuildingById(id));
    }

    @GetMapping("/by-request")
    public ResponseEntity<Building> getBuildingByRequestedParam(@RequestParam Long id) {
        return ResponseEntity.ok(buildingService.getBuildingById(id));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteBuildingById(@RequestParam Long id) {
        buildingService.deleteBuildingById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Building> updateBuilding(@RequestBody Building building) {
        return ResponseEntity.ok(buildingService.updateBuilding(building));
    }
}

