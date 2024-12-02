package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class PrescriptionMedicament {

    /*
    ENTITES MISE DE COTE POUR L'INSTANT
     */

    @EmbeddedId
    private PrescriptionMedicamentId id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("medicamentId")
    private Medicament medicament;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("prescriptionId")
    private Prescriptions prescriptions;

    public PrescriptionMedicament(PrescriptionMedicamentId id, int quantity, Medicament medicament, Prescriptions prescriptions) {
        this.id = new PrescriptionMedicamentId(prescriptions.getId(), medicament.getId());
        this.quantity = quantity;
        this.medicament = medicament;
        this.prescriptions = prescriptions;
    }

    @Embeddable
    @Getter @Setter
    @NoArgsConstructor
    public static class PrescriptionMedicamentId{
        private UUID prescriptionId;
        private UUID medicamentId;

        public PrescriptionMedicamentId(UUID prescriptionId, UUID medicamentId) {
            this.prescriptionId = prescriptionId;
            this.medicamentId = medicamentId;
        }
    }
}
