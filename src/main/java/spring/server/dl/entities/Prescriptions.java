package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.StatusPrescription;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true) @ToString
public class Prescriptions extends BaseEntity{

    /*
    ENTITES MISE DE COTE POUR L'INSTANT
     */

    @Column(nullable = false)
    private LocalDate prescription_date;

    @Column(nullable = false)
    private LocalDate expiration_date;

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false)
    private String special_instructions;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPrescription statut;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;

    @ManyToOne
    private Professional professional;

    @OneToMany(mappedBy = "prescriptions")
    private Set<PrescriptionMedicament> prescriptionMedicament = new HashSet<>();

    public Prescriptions(UUID id, LocalDate prescription_date, LocalDate expiration_date, String motif, String special_instructions, StatusPrescription statut) {
        super(id);
        this.prescription_date = prescription_date;
        this.expiration_date = expiration_date;
        this.motif = motif;
        this.special_instructions = special_instructions;
        this.statut = statut;
    }
}
