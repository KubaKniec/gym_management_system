package pl.edu.pjatk.gym_management_system.model;

import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Ticket")
public class Ticket {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "clientId")
    private Long clientId;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "expireDate")
    private LocalDate expireDate;

    @Column(name = "ticketCategory")
    private TicketCategory ticketCategory;

    @Column(name = "price")
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
