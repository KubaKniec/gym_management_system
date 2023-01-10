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

    @GetMapping
    public ResponseEntity <List<Client>> findAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable("id") Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Client> getClientByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClientById(@RequestParam("id") Long id){
        clientService.deleteClientById(id);
        return ResponseEntity.ok("ok");
    }

    //todo update

}
