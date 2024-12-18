package spring.server.dl.entities.person;

import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.Certificat;
import spring.server.dl.entities.Consultation;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@NoArgsConstructor
@Getter @Setter
@Table( uniqueConstraints = {
        @UniqueConstraint(name = "uk_person", columnNames = {"firstName", "lastName", "birthDate"})
})
public class Patient extends Person{

    // Modification patient

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(length = 250)
    private String mutuelle;

    @Column(length = 500)
    private String info_supplement;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;


    public Patient(UUID id, String firstName, String lastName, LocalDate birthDate, String mutuelle, String info_supplement, Address address) {
        super(id, firstName, lastName);
        this.birthDate = birthDate;
        this.mutuelle = mutuelle;
        this.info_supplement = info_supplement;
        this.address = address;
    }

    public Patient(UUID id, String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, String mutuelle, String info_supplement, Address address) {
        super(id, firstName, lastName, email, phoneNumber);
        this.birthDate = birthDate;
        this.mutuelle = mutuelle;
        this.info_supplement = info_supplement;
        this.address = address;
    }

    public Patient(UUID id, String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, String mutuelle, String info_supplement) {
        super(id, firstName, lastName, email, phoneNumber);
        this.birthDate = birthDate;
        this.mutuelle = mutuelle;
        this.info_supplement = info_supplement;
    }

    public Patient(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, String mutuelle, String info_supplement, Address address) {
        super(firstName, lastName, email, phoneNumber);
        this.birthDate = birthDate;
        this.mutuelle = mutuelle;
        this.info_supplement = info_supplement;
        this.address = address;
    }
}
