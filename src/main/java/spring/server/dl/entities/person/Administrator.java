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

}
