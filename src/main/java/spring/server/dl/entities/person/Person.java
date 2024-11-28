package spring.server.dl.entities.person;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import spring.server.dl.entities.BaseEntity;
import spring.server.dl.enums.Roles;

import java.util.UUID;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @Column(unique = true, length = 15)
    private String phoneNumber;

    @Column()
    @Setter(AccessLevel.NONE)
    private String password;

    public Person(UUID id, String firstName, String lastName, Roles role) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
