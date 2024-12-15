package spring.server.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.server.api.models.dtos.patientDTO.BasicInfosDTO;
import spring.server.api.models.dtos.patientDTO.TotalInfosDTO;
import spring.server.api.models.forms.PatientForm;
import spring.server.bll.PatientsService;
import spring.server.dl.entities.person.Patient;

import java.net.URI;
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


//    Modification de postMapping par AYOUB
    @PostMapping
    public ResponseEntity<Void> addPatient(@Valid @RequestBody PatientForm patientForm) {
        System.out.println("PatientForm: " + patientForm);

        Patient patient = patientForm.toPatient();
        Patient createdPatient = patientsService.createPatient(patient);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdPatient.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePatient(@PathVariable UUID id, @Valid @RequestBody PatientForm patientForm) {
        System.out.println("Updating Patient: " + id);
        Patient patient = patientForm.toPatient();
        patient.setId(id);
        patientsService.updatePatient(patient);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        Patient patient = patientsService.findPatientById(id);
        patientsService.deletePatient(patient);
        return ResponseEntity.noContent().build();
    }



}
