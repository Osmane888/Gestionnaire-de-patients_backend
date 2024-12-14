package spring.server.api.models.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import spring.server.dl.entities.person.Professional;

public record LoginForm(
        @NotBlank @Email
        String email,
        @NotBlank
        String password
) {

    public Professional toProfessional(){
        return new Professional(email, password);
    }
}
