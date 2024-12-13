package spring.server.api.models.forms;

import jakarta.validation.constraints.NotBlank;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.person.Patient;

import java.time.LocalDate;
import java.util.UUID;

public record PatientForm(

        @NotBlank(message = "Required field")
        String firstName,
        @NotBlank(message = "Required field")
        String lastName,
        String email,
        String phoneNumber,
        @NotBlank(message = "Required field")
        LocalDate birthDate,
        String mutuelle,
        String info_supplement,
        @NotBlank(message = "Required field")
        Address address
) {

        public Patient toPatient(){
                return new Patient(
                        firstName,
                        lastName,
                        email,
                        phoneNumber,
                        birthDate,
                        mutuelle,
                        info_supplement,
                        new Address(
                                address().getCity(),
                                address().getStreet(),
                                address().getNumber(),
                                address().getZipCode()
                        )
                );
        }
}
