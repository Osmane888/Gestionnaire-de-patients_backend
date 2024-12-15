package spring.server.api.models.dtos;

import spring.server.dl.entities.person.Professional;

public record ProfessionalTokenDTO(
        ProfessionalDTO professional,
        String token
) {
}
