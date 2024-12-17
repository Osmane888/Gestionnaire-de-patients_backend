package spring.server.api.models.dtos;

import org.apache.catalina.Role;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.Roles;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record ProfessionalDTO(
        String firstName,
        String lastName,
        UUID id,
        String email,
        Roles roles
) {

    public static ProfessionalDTO fromProfessional(Professional professional){
        return new ProfessionalDTO(
                professional.getFirstName(),
                professional.getLastName(),
                professional.getId(),
                professional.getEmail(),
                professional.getRole()

        );
    }
}