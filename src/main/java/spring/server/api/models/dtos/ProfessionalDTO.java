package spring.server.api.models.dtos;

import java.util.UUID;

public record ProfessionalDTO(
        UUID id,
        String email
) {
}
