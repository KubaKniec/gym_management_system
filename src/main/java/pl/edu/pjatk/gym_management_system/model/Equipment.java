package pl.edu.pjatk.gym_management_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@ToString(exclude = "building")
@Table
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "needs_repair")
    private boolean needsFixing;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_building")
    private Building building;
}
