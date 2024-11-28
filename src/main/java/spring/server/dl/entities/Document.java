package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.person.Patient;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String documentName;

    @Column(nullable = false)
    private String documentType;

    @Column(nullable = false)
    private int documentSize;

    @Column(nullable = false)
    private String documentUrl;

    @ManyToOne
    private Patient patient;
}
