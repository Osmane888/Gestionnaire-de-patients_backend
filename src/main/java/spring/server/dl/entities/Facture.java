package spring.server.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@EqualsAndHashCode @ToString
@NoArgsConstructor
public class Facture {

    @Id
    private UUID id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime generationDate;
}
