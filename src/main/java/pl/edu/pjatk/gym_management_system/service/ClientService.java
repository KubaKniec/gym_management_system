package pl.edu.pjatk.gym_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.repository.ClientRepository;

import java.util.List;

//crud
//create
//read
//update
//delete

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    public Client findClientByFistNameAndLastName(String firstName, String lastName) {
        return clientRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(IllegalArgumentException::new);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }
}
