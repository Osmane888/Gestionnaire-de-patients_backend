package spring.server.dl.entities;


import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.StatusRdv;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate dateRdv;

    @Column(nullable = false)
    private Timestamp hourRdv;

    @Column(nullable = false)
    private LocalTime durationRdv;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusRdv statusRdv;

    @Column(nullable = false)
    private String rdvType;

    @Column()
    private String consigne;

    @Column()
    private int annulationDelay;

    @ManyToOne
    private Address addresses;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Professional professional;

    @ManyToOne
    private Facture facture;
}
