package spring.server.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.api.models.dtos.patientDTO.BasicInfosDTO;
import spring.server.api.models.dtos.patientDTO.TotalInfosDTO;
import spring.server.bll.PatientsService;
import spring.server.dl.entities.person.Patient;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {

    private final PatientsService patientsService;

    @GetMapping
    public ResponseEntity<List<BasicInfosDTO>> findAll() {

        List<BasicInfosDTO> patients = patientsService.findAllPatient().stream()
                .map(BasicInfosDTO::fromPatient)
                .toList();

        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TotalInfosDTO> findById(@PathVariable UUID id) {

        TotalInfosDTO dto = TotalInfosDTO.fromPatientTotalInfos(patientsService.findPatientById(id));
        return ResponseEntity.ok(dto);
    }
}
