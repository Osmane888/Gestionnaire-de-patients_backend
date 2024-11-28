package spring.server.dl.entities.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Professional extends Person{

    @Column(unique = true, nullable = false)
    private String licenseNumber;

    @Column()
    private boolean valid;

    @Column(nullable = false, length = 120)
    private String specialization;
}
