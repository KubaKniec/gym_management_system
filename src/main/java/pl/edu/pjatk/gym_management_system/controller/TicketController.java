package pl.edu.pjatk.gym_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/ticket/")
public class TicketController {

    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets(){
        return ResponseEntity.ok(ticketService.findAllTickets());
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable("id") Long id){
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @GetMapping("/{price}")
    public ResponseEntity<Ticket> findAllTicketsByPrice(@PathVariable("price") Double price){
        return ResponseEntity.ok(ticketService.findAllTicketsByPrice(price));
    }

    @GetMapping("/get")
    public ResponseEntity<Ticket> getTicketByIdRequestedParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTicketById(@RequestParam("id") Long id){
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("ok");
    }

    //todo update ticket

}
