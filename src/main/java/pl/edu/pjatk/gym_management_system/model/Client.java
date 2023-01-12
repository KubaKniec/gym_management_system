package pl.edu.pjatk.gym_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pjatk.gym_management_system.model.enums.Gender;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    private Gender gender;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_trainer")
    private Trainer trainer;
}
