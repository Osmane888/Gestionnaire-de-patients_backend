package spring.server.api.models.dtos.patientDTO;

import spring.server.dl.entities.Address;
import spring.server.dl.entities.person.Patient;

import java.time.LocalDate;
import java.util.UUID;

public record BasicInfosDTO(
        UUID id,
        String lastname,
        String firstname,
        String email,
        String phoneNumber,
        String fullname
) {

    public static BasicInfosDTO fromPatient(Patient patient) {
        return new BasicInfosDTO(
                patient.getId(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getEmail(),
                patient.getPhoneNumber(),
                patient.getLastName() + " " + patient.getFirstName()
        );
    }
}
