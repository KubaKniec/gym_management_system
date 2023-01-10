package pl.edu.pjatk.gym_management_system.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.gym_management_system.service.ClientService;

@RestController
@RequestMapping("/client/")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }


}
