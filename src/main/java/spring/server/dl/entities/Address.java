package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 250)
    private String street;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String zipCode;

    public Address(int id, String street, String city, String number, String zipCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.number = number;
        this.zipCode = zipCode;
    }
}
