package spring.server.dl.entities.person;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import spring.server.dl.entities.BaseEntity;
import spring.server.dl.enums.Roles;

import java.util.UUID;

@Getter @Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public abstract class Person extends BaseEntity {

    @Column(nullable = false, length = 150)
    private String firstName;

    @Column(nullable = false, length = 200)
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 15)
    private String phoneNumber;

    @Column()
    @Setter(AccessLevel.NONE)
    private String password;

    public Person(UUID id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(UUID id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
