package spring.server.dl.entities;


import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.StatusRdv;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class Consultation extends BaseEntity{

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
    private Address address;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Professional professional;

    @ManyToOne
    private Facture facture;

    @ManyToOne
    private Certificat certificat;


    public Consultation(UUID id, LocalDate dateRdv, Timestamp hourRdv, LocalTime durationRdv, StatusRdv statusRdv, String rdvType, String consigne, int annulationDelay, Address address, Patient patient, Professional professional, Facture facture, Certificat certificat) {
        super(id);
        this.dateRdv = dateRdv;
        this.hourRdv = hourRdv;
        this.durationRdv = durationRdv;
        this.statusRdv = statusRdv;
        this.rdvType = rdvType;
        this.consigne = consigne;
        this.annulationDelay = annulationDelay;
        this.address = address;
        this.patient = patient;
        this.professional = professional;
        this.facture = facture;
        this.certificat = certificat;
    }
}
