package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client/")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping  //dziala
    public ResponseEntity<List<Client>> getAllClient() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @PostMapping  //dziala
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/{id}")  //dziala
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/{name}/{lastname}") //dziala
    public ResponseEntity<Client> getClientByFirstNameAndLastName(@PathVariable("name") String name, @PathVariable("lastname") String lastname) {
        return ResponseEntity.ok(clientService.findClientByFistNameAndLastName(name, lastname));
    }

    @GetMapping("/get") //nie dziala
    public ResponseEntity<Client> getClientByIdRequestParam(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping  //dziala
    public ResponseEntity<String> deleteAuthorById(@RequestParam("id") Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok("ok");


        //todo update client

    }
}
