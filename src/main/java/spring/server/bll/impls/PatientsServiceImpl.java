package spring.server.bll.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
        Patient patient = patientRepository.findById(id).orElse(null);
        return patient;
    }

    @Override
    public Patient findPatientByEmail(String email) {
        return null;
    }

    @Override
    public Patient findPatientByLastNameAndFirstName(String lastName, String firstName) {
        return null;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return null;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return null;
    }

    @Override
    public void deletePatient(Patient patient) {

    }
}
