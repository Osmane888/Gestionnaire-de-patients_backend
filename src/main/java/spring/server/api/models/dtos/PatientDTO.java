package spring.server.api.models.dtos;

import spring.server.dl.entities.Address;
import spring.server.dl.entities.person.Patient;

import java.time.LocalDate;
import java.util.UUID;

public record PatientDTO(
        UUID id,
        String lastname,
        String firstname,
        String email,
        String phoneNumber,
        LocalDate birthDate,
        String mutuelle,
        String info_supplement,
        Address address
) {

    public static PatientDTO fromPatient(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getEmail(),
                patient.getPhoneNumber(),
                patient.getBirthDate(),
                patient.getMutuelle(),
                patient.getInfo_supplement(),
                patient.getAddress()
        );
    }
}
