package spring.server.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true) @ToString
public class Medicament extends BaseEntity {

    /*
    ENTITES MISE DE COTE POUR L'INSTANT
     */
    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String posologie;

    @Column(nullable = false)
    private int duration;

    public Medicament(UUID id, String name, String posologie, int duration) {
        super(id);
        this.name = name;
        this.posologie = posologie;
        this.duration = duration;
    }

}
