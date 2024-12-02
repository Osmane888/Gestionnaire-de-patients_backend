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

    public Administrator(UUID id, String firstName, String lastName,  String email, String phoneNumber, String password) {
        super(id, firstName, lastName, email, phoneNumber, password);
    }
}
