package spring.server.api.models.dtos.patientDTO;

import spring.server.dl.entities.Address;
import spring.server.dl.entities.person.Patient;

import java.time.LocalDate;
import java.util.UUID;

public record TotalInfosDTO(
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

    public static TotalInfosDTO fromPatientTotalInfos(Patient patient) {
        return new TotalInfosDTO(
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
