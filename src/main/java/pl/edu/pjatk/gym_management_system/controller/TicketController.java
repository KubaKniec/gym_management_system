package pl.edu.pjatk.gym_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.gym_management_system.model.Ticket;
import pl.edu.pjatk.gym_management_system.service.TicketService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.findAllTickets());
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/by-path/{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @GetMapping("/{price}")
    public ResponseEntity<List<Ticket>> findAllTicketsByPrice(@PathVariable Double price) {
        return ResponseEntity.ok(ticketService.findAllTicketsByPrice(price));
    }

    @GetMapping("/by-request")
    public ResponseEntity<Ticket> getTicketByIdRequestedParam(@RequestParam Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteTicketById(@RequestParam Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.updateTicket(ticket));
    }
}
