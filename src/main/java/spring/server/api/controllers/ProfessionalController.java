package spring.server.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.bll.ProfessionalService;
import spring.server.dl.entities.person.Professional;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professionals")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessionalController {

    private final ProfessionalService professionalService;


    @GetMapping
    public ResponseEntity<List<Professional>> getAllProfessionals() {
        List<Professional> professionals = professionalService.findAllProfessional();
        return ResponseEntity.ok(professionals);
    }

    // **Créer un nouveau professionnel**
//    @PostMapping
//    public ResponseEntity<Professional> createProfessional(
//            @Valid @RequestBody ProfessionalForm form) {
//
//        Professional professional = form.toProfessional();  // Conversion du DTO à l'entité
//        Professional createdProfessional = professionalService.createProfessional(professional);
//
//        return new ResponseEntity<>(createdProfessional, HttpStatus.CREATED);
//    }

    // **Récupérer un professionnel par ID**
    @GetMapping("/{id}")
    public ResponseEntity<Professional> getProfessionalById(@PathVariable UUID id) {
        Professional professional = professionalService.findPatientById(id);
        if (professional == null) {
            return ResponseEntity.notFound().build();  // Retourne 404 si non trouvé
        }
        return ResponseEntity.ok(professional);  // Retourne 200 avec les détails du professionnel
    }

    // **Supprimer un professionnel par ID**
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable UUID id) {
        Professional professional = professionalService.findPatientById(id);
        if (professional == null) {
            return ResponseEntity.notFound().build();  // Retourne 404 si non trouvé
        }
        professionalService.deleteProfessional(professional);
        return ResponseEntity.noContent().build();  // Retourne 204 sans contenu
    }


}
