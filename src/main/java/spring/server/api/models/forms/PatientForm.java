package spring.server.api.models.forms;

import jakarta.validation.constraints.NotBlank;
import spring.server.dl.entities.Address;

import java.time.LocalDate;

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
}
