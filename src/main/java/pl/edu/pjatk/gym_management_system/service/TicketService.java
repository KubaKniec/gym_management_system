package pl.edu.pjatk.gym_management_system.service;

//crud
//create
//read
//update
//delete

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.getReferenceById(id);
    }

    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }

    //todo sprawdzic dzialanie tej metody, moze bedzie miala zwracac np liste ???
    public Ticket findAllTicketsByPrice(Double price){

        Optional<Ticket> ticket = ticketRepository.findAllTicketsByPrice(price);
        if (ticket.isPresent()){
            return ticket.get();
        }
        throw new IllegalArgumentException();
    }

    //todo update ticket
}
