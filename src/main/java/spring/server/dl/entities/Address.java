package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class Address{

    @Column(nullable = false, length = 250)
    private String street;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    private Consultation consultation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Address(String street, String city, String number, String zipCode) {
        this.street = street;
        this.city = city;
        this.number = number;
        this.zipCode = zipCode;
    }
}
