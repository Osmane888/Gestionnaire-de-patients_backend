package spring.server.api.controllers.security;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.server.api.models.dtos.ProfessionalDTO;
import spring.server.api.models.dtos.ProfessionalTokenDTO;
import spring.server.api.models.forms.LoginForm;
import spring.server.bll.security.AuthService;
import spring.server.dl.entities.person.Professional;
import spring.server.il.utils.JwtUtils;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<ProfessionalTokenDTO> login(@Valid @RequestBody LoginForm loginForm){

        Professional professional = authService.login(loginForm.toProfessional());
        ProfessionalDTO professionalDTO = ProfessionalDTO.fromProfessional(professional);
        ProfessionalTokenDTO professionalTokenDTO = new ProfessionalTokenDTO(professionalDTO, jwtUtils.generateToken(professional));

        return ResponseEntity.ok(professionalTokenDTO);
    }

}