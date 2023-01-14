package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Equipment;
import pl.edu.pjatk.gym_management_system.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EqupimentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        return ResponseEntity.ok(equipmentService.findAllEquipments());
    }

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {
        return ResponseEntity.ok(equipmentService.createEquipment(equipment));
    }

    @GetMapping("/by-path/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Long id) {
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }

    @GetMapping("/by-request")
    public ResponseEntity<Equipment> getEquipmentByIdRequestParam(@RequestParam Long id) {
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteEquipmentById(@RequestParam Long id) {
        equipmentService.deleteEquipmentById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity<Equipment> updateEquipment(@RequestBody Equipment equipment) {
        return ResponseEntity.ok(equipmentService.updateEquipment(equipment));
    }
}