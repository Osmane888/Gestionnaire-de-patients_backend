package spring.server.api.models.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.Roles;

import java.util.UUID;

public record RegisterForm(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String email,
        @NotBlank
        String phoneNumber,
        @NotBlank
        String licenseNumber,
        @NotNull
        Roles role,
        @NotBlank
        String specialization,
        @NotBlank
        String password
) {

    public Professional toProfessional(){
        return new Professional(firstName, lastName, email, phoneNumber, licenseNumber, role, specialization, password);
    }
}
