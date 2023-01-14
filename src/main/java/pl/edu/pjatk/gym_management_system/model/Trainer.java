package pl.edu.pjatk.gym_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.edu.pjatk.gym_management_system.model.enums.Gender;
import pl.edu.pjatk.gym_management_system.model.enums.TrainerQualifications;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    private Gender gender;
    private TrainerQualifications qualifications;
    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_building")
    private Building building;
}
