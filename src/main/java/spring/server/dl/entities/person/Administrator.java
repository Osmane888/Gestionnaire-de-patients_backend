package spring.server.dl.entities.person;

import jakarta.persistence.Entity;
import lombok.*;
import spring.server.dl.enums.Roles;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)

public class Administrator extends Person{

    public Administrator(UUID id, String firstName, String lastName, Roles role, String email, String phoneNumber) {
        super(id, firstName, lastName, role, email, phoneNumber);
    }
}
