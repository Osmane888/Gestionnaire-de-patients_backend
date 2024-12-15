package spring.server.api.models.forms;

import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.Roles;

import java.util.UUID;

public record RegisterForm(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String licenseNumber,
        Roles role,
        String specialization,
        String password
) {

    public Professional toProfessional(){
        return new Professional(UUID.randomUUID(), firstName, lastName, email, phoneNumber, licenseNumber, role, specialization, password);
    }
}
