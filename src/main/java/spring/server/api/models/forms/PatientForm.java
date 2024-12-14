package spring.server.api.models.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.person.Patient;

import java.time.LocalDate;


//    Modification de postForm AYOUB
public record PatientForm(
        @NotBlank(message = "First name is required") String firstName,
        @NotBlank(message = "Last name is required") String lastName,
        String email,
        String phoneNumber,
        @NotNull(message = "Birth date is required") LocalDate birthDate,
        String mutuelle,
        String info_supplement,
        @Valid @NotNull(message = "Address is required") Address address
) {
        public Patient toPatient() {
                return new Patient(
                        firstName,
                        lastName,
                        email,
                        phoneNumber,
                        birthDate,
                        mutuelle,
                        info_supplement,
                        address
                );
        }
}
