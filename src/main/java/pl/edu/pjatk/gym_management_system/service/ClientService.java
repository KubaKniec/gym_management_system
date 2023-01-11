package pl.edu.pjatk.gym_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Client;
import pl.edu.pjatk.gym_management_system.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

//crud
//create
//read
//update
//delete

@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public void ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public Client createClient(Client client){
        return clientRepository.save(client);
    }
    public List<Client> findAllClients(){return clientRepository.findAll();}

    public Client getClientById(Long id){return clientRepository.getReferenceById(id);}

    public void deleteClientById(Long id){clientRepository.deleteById(id);}

    public Client findClientByFistNameAndLastName(String firstName,String lastName){

        Optional<Client> client = clientRepository.findClientByFirstNameAndLastName(firstName,lastName);

        if (client.isPresent()){

            return client.get();
        }
        throw new IllegalArgumentException();
    }


//    ClientRepository clientRepository;
//
//    @Autowired
//    public void ClientService(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }
//
//    public Client createClient(Client client) {
//        return clientRepository.save(client);
//    }
//
//    public List<Client> getAllClients() {
//        return clientRepository.findAll();
//    }
//
//    public Client getClientById(Long id) {
//        Optional<Client> b = clientRepository.findById(id);
//        if (b.isPresent()) {
//            return b.get();
//        }
//        throw new IllegalArgumentException();
//    }
//
//    public Client findClientByFirstNameAndLastName(String firstName, String lastName) {
//        Optional<Client> client = clientRepository.findClientByFirstNameAndLastName(firstName, lastName);
//        if (client.isPresent()) {
//            return client.get();
//        }
//        throw new IllegalArgumentException();
//    }
//
//    public void deleteClientById(Long id) {
//        clientRepository.deleteById(id);
//    }

    //todo update
}
