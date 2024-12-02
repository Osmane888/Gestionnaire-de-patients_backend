package spring.server.dl.entities.person;

import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.Certificat;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.Prescriptions;
import spring.server.dl.enums.Roles;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Professional extends Person{

    @Getter
    @Column(unique = true)
    private String licenseNumber;

    @Getter
    @Column()
    private boolean valid;

    @Getter
    @Column()
    private Roles role;

    @Getter
    @Column(nullable = false, length = 120)
    private String specialization;

    public Professional(UUID id, String firstName, String lastName, String email, String phoneNumber, String password, String licenseNumber, boolean valid, Roles role, String specialization) {
        super(id, firstName, lastName, email, phoneNumber, password);
        this.licenseNumber = licenseNumber;
        this.valid = valid;
        this.role = role;
        this.specialization = specialization;
    }
}
