package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class Address {

    // Modification Adress
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 250)
    private String street;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 20)
    private String streetNumber;

    @Column(nullable = false, length = 10)
    private String zipCode;

    public Address(String street, String city, String streetNumber, String zipCode) {
        this.street = street;
        this.city = city;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }
}