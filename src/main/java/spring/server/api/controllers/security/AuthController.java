package spring.server.api.controllers.security;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.server.api.models.dtos.ProfessionalDTO;
import spring.server.api.models.dtos.ProfessionalTokenDTO;
import spring.server.api.models.forms.LoginForm;
import spring.server.api.models.forms.RegisterForm;
import spring.server.bll.security.AuthService;
import spring.server.dl.entities.person.Professional;
import spring.server.il.utils.JwtUtils;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<ProfessionalTokenDTO> login(@Valid @RequestBody LoginForm loginForm){

        Professional professional = authService.login(loginForm.toProfessional());
        ProfessionalDTO professionalDTO = ProfessionalDTO.fromProfessional(professional);
        ProfessionalTokenDTO professionalTokenDTO = new ProfessionalTokenDTO(professionalDTO, jwtUtils.generateToken(professional));

        return ResponseEntity.ok(professionalTokenDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterForm registerForm){
        authService.register(registerForm.toProfessional());
        return ResponseEntity.noContent().build();
    }
}