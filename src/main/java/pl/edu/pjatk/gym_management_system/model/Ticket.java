package pl.edu.pjatk.gym_management_system.model;

import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "client_Id")
//    private Long clientId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "ticket_category")
    private TicketCategory ticketCategory;

    @Column(name = "price")
    private double price;

    public Ticket() {
    }

    public Ticket(Long id, LocalDate startDate, LocalDate expireDate, TicketCategory ticketCategory, double price) {
        this.id = id;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.ticketCategory = ticketCategory;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getClientId() {
//        return clientId;
//    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public double getPrice() {
        return price;
    }


}
