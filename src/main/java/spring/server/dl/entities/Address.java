package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true) @ToString
public class Address extends BaseEntity{

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Professional> professionals = new HashSet<>();

    public Address(UUID id, String street, String city, String number, String zipCode) {
        super(id);
        this.street = street;
        this.city = city;
        this.number = number;
        this.zipCode = zipCode;
    }
}
