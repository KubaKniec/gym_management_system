package pl.edu.pjatk.gym_management_system.model;

import javax.persistence.*;

@Entity
@Table(name = "Placeholder")
public class Placeholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
