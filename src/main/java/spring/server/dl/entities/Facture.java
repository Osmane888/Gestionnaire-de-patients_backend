package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true) @ToString
@NoArgsConstructor
public class Facture extends BaseEntity{

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime generationDate;

    @OneToOne
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    private Consultation consultation;


    public Facture(UUID id, Double amount, LocalDateTime generationDate, Consultation consultation) {
        super(id);
        this.amount = amount;
        this.generationDate = generationDate;
        this.consultation = consultation;
    }
}