package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping  //dziala
    public ResponseEntity<List<Client>> getAllClient() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @PostMapping  //dziala
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/by-path/{id}")  //dziala
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/{name}/{lastname}") //dziala
    public ResponseEntity<Client> getClientByFirstNameAndLastName(@PathVariable String name, @PathVariable String lastname) {
        return ResponseEntity.ok(clientService.findClientByFistNameAndLastName(name, lastname));
    }

    @GetMapping("/by-request") //nie dziala http://localhost:8080/api/client/get/1
    public ResponseEntity<Client> getClientByIdRequestParam(@RequestParam Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping  //dziala
    public ResponseEntity<Long> deleteAuthorById(@RequestParam Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(client));
    }
}
