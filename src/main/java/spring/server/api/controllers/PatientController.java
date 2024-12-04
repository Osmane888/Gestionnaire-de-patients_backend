package spring.server.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.server.api.models.dtos.PatientDTO;
import spring.server.bll.PatientsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {

    private final PatientsService patientsService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll() {

        List<PatientDTO> patients = patientsService.findAllPatient().stream()
                .map(PatientDTO::fromPatient)
                .toList();

        return ResponseEntity.ok(patients);
    }
}
