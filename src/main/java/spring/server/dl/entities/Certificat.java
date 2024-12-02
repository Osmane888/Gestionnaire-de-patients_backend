package spring.server.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true) @ToString
public class Certificat extends BaseEntity {

    /*
    ENTITES MISE DE COTE POUR L'INSTANT
     */

    @Column(nullable = false)
    private LocalDate dateArret;

    @Column(nullable = false)
    private LocalDate dateReprise;

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false)
    private String healthStatus;

    @Column(nullable = false)
    private int nbRestDays;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Professional professional;

    public Certificat(UUID id, LocalDate dateArret, LocalDate dateReprise, String motif, String healthStatus, int nbRestDays, Patient patient, Professional professional) {
        super(id);
        this.dateArret = dateArret;
        this.dateReprise = dateReprise;
        this.motif = motif;
        this.healthStatus = healthStatus;
        this.nbRestDays = nbRestDays;
        this.patient = patient;
        this.professional = professional;
    }
}
