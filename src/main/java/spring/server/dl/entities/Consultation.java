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
@EqualsAndHashCode(callSuper = true) @ToString
public class Consultation extends BaseEntity{

    @Column(nullable = false)
    private LocalDate dateRdv;

    @Column(nullable = false)
    private LocalTime hourRdv;

    @Column(nullable = false)
    private LocalTime durationRdv;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusRdv statusRdv;

    @Column(nullable = false, length = 1000)
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


    public Consultation(LocalDate dateRdv, LocalTime hourRdv, LocalTime durationRdv, StatusRdv statusRdv, String rdvType, String consigne, int annulationDelay, Address address, Patient patient, Professional professional, Facture facture, Certificat certificat) {
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

    public Consultation(LocalTime hourRdv, LocalDate dateRdv, LocalTime durationRdv, StatusRdv statusRdv, String rdvType) {
        this.hourRdv = hourRdv;
        this.dateRdv = dateRdv;
        this.durationRdv = durationRdv;
        this.statusRdv = statusRdv;
        this.rdvType = rdvType;
    }

    public Consultation(LocalDate dateRdv, LocalTime hourRdv, LocalTime durationRdv, StatusRdv statusRdv, String rdvType, Patient patient) {
        this.dateRdv = dateRdv;
        this.hourRdv = hourRdv;
        this.durationRdv = durationRdv;
        this.statusRdv = statusRdv;
        this.rdvType = rdvType;
        this.patient = patient;
    }
}