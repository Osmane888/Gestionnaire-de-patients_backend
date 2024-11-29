package spring.server.dl.entities.person;

import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.Certificat;
import spring.server.dl.entities.Consultation;

import java.time.LocalDate;

@Entity
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@NoArgsConstructor
@Getter @Setter
@Table( uniqueConstraints = {
        @UniqueConstraint(name = "uk_person", columnNames = {"firstName", "lastName", "birthDate"})
})
public class Patient extends Person{

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(length = 250)
    private String mutuelle;

    @Column(length = 500)
    private String info_supplement;

    @ManyToOne
    private Address address;
}
