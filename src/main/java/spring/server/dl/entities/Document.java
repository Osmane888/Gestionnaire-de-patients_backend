package spring.server.dl.entities;

import jakarta.persistence.*;
import lombok.*;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString
public class Document extends BaseEntity{

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

    public Document(UUID id, String documentName, String documentType, int documentSize, String documentUrl, Patient patient) {
        super(id);
        this.documentName = documentName;
        this.documentType = documentType;
        this.documentSize = documentSize;
        this.documentUrl = documentUrl;
        this.patient = patient;
    }
}
