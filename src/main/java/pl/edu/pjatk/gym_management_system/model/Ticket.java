package pl.edu.pjatk.gym_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pjatk.gym_management_system.model.enums.TicketCategory;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "expire_date")
    private LocalDate expireDate;
    @Column(name = "ticket_category")
    private TicketCategory ticketCategory;
    private double price;
}
