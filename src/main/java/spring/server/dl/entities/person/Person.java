package spring.server.dl.entities.person;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import spring.server.dl.entities.BaseEntity;
import spring.server.dl.enums.Roles;

import java.util.UUID;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public abstract class Person extends BaseEntity {

    @Column(nullable = false, length = 150)
    private String firstName;

    @Column(nullable = false, length = 200)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Column(unique = true)
    private String email;

    @Column()
    @Setter(AccessLevel.NONE)
    private String password;

    public Person(UUID id, String firstName, String lastName, Roles role) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Person(UUID id, String firstName, String lastName, Roles role, String email, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.password = password;
    }
}
