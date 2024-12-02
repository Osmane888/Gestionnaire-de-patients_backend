package spring.server.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    public Facture(UUID id, Double amount, LocalDateTime generationDate) {
        super(id);
        this.amount = amount;
        this.generationDate = generationDate;
    }
}