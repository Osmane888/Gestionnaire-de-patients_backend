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

        patientExisting.setFirstName(patient.getFirstName());
        patientExisting.setLastName(patient.getLastName());
        return patientRepository.save(patientExisting);
    }

    @Override
    public void deletePatient(Patient patient) {

    }
}
