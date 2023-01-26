package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.service.ClientService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    Logger log = Logger.getLogger(ClientController.class.getName());

    @GetMapping
    public ResponseEntity<List<Client>> getAllClient() {
        log.info("Get all clients");
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        log.info("Create client");
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/by-path/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        log.info("Get client by id");
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/{name}/{lastname}")
    public ResponseEntity<Client> getClientByFirstNameAndLastName(@PathVariable String name, @PathVariable String lastname) {
        log.info("Get client by name and last name");
        return ResponseEntity.ok(clientService.findClientByFistNameAndLastName(name, lastname));
    }

    @GetMapping("/by-request")
    public ResponseEntity<Client> getClientByIdRequestParam(@RequestParam Long id) {
        log.info("Get client by id");
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteClientById(@RequestParam Long id) {
        log.info("Delete client");
        clientService.deleteClientById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        log.info("Update client");
        return ResponseEntity.ok(clientService.updateClient(client));
    }
}
