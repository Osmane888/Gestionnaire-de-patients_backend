package spring.server.bll.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.server.api.models.dtos.patientDTO.TotalInfosDTO;
import spring.server.bll.PatientsService;
import spring.server.dal.repositories.PatientRepository;
import spring.server.dl.entities.person.Patient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientsServiceImpl implements PatientsService {

    private final PatientRepository patientRepository;


    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findPatientById(UUID id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient findPatientByLastNameAndFirstName(String lastName, String firstName) {
        return patientRepository.findByAppelation(lastName,firstName).orElseThrow();
    }

    @Override
    public Patient createPatient(Patient patient) {
        if(patientRepository.existsByAppelation(patient.getFirstName(), patient.getLastName())) {
            throw new IllegalArgumentException("Le patient existe déjà");
        }
        patient.setId(UUID.randomUUID());

        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Patient patientExisting = findPatientById(patient.getId());

        patient.setId(UUID.randomUUID());
        patient.setFirstName(patient.getFirstName());
        patient.setLastName(patient.getLastName());
        patient.setEmail(patient.getEmail());
        patient.setPhoneNumber(patient.getPhoneNumber());
        patient.setBirthDate(patient.getBirthDate());
        patient.setMutuelle(patient.getMutuelle());
        patient.setInfo_supplement(patient.getInfo_supplement());
        patient.setAddress(patient.getAddress());
        return patientRepository.save(patientExisting);
    }

    @Override
    public void deletePatient(Patient patient) {

    }
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

//@PutMapping("/{id}")
//public ResponseEntity<Void> updatePatient(@PathVariable UUID id, @Valid @RequestBody PatientForm patientForm) {
//    System.out.println("Updating Patient: " + id);
//    Patient patient = patientForm.toPatient();
//    patient.setId(id);
//    patientsService.updatePatient(patient);
//    return ResponseEntity.noContent().build();
//}
//
//@DeleteMapping("/{id}")
//public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
//    Patient patient = patientsService.findPatientById(id);
//    patientsService.deletePatient(patient);
//    return ResponseEntity.noContent().build();//
//}




