package spring.server.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.server.api.models.dtos.consultationDTO.TotalConsultationInfosDTO;
import spring.server.api.models.dtos.patientDTO.TotalInfosDTO;
import spring.server.api.models.forms.ConsultationForm;
import spring.server.bll.ConsultationService;
import spring.server.bll.PatientsService;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.person.Patient;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultationController {

    private final ConsultationService consultationService;
    private final PatientsService patientService;

    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        List<Consultation> consultations = consultationService.findAllConsultation();
        return ResponseEntity.ok(consultations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TotalConsultationInfosDTO> getConsultationById(@PathVariable UUID id) {
        Consultation consultation = consultationService.findConsultationById(id);
        if (consultation == null) {
            return ResponseEntity.notFound().build();
        }
        TotalConsultationInfosDTO dto = TotalConsultationInfosDTO.fromTotalConsultationInfos(consultation);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Consultation> createConsultation(@RequestBody @Validated ConsultationForm form) {
        Consultation consultation = form.toConsultation();
        Consultation savedConsultation = consultationService.createConsultation(consultation, form.patientid()); // Erreur ici
        return ResponseEntity.ok(savedConsultation);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable UUID id) {
        Consultation consultation = consultationService.findConsultationById(id);
        if (consultation == null) {
            return ResponseEntity.notFound().build();
        }
        consultationService.deleteConsultation(consultation);
        return ResponseEntity.noContent().build();
    }
}