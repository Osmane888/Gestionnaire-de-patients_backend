package spring.server.bll.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.server.api.models.dtos.patientDTO.TotalInfosDTO;
import spring.server.bll.PatientsService;
import spring.server.dal.repositories.PatientRepository;
import spring.server.dl.entities.person.Patient;

import java.util.List;
import java.util.Optional;
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
    public List<Patient> findPatientByLastNameAndFirstName(String lastName, String firstName) {
        return patientRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    @Override
    public List<Patient> findPatientByLastNameOrFirstName(String name) {
        return patientRepository.findByLastNameOrFirstName(name);
    }




    //    Ajout de createPatient et UpdatePatient par AYOUB
    @Override
    public Patient createPatient(Patient patient) {
        if(patientRepository.existsByAppelation(patient.getLastName(), patient.getFirstName())) {
            throw new IllegalArgumentException("Le patient existe déjà");
        }
        if (patient.getAddress() == null) {
            throw new IllegalArgumentException("Address is required.");
        }
        patient.setId(UUID.randomUUID());

        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Patient patientExisting = findPatientById(patient.getId());
        if (patientExisting == null) {
            throw new IllegalArgumentException("Patient inexistant");
        }
        patientExisting.setFirstName(patient.getFirstName());
        patientExisting.setLastName(patient.getLastName());
        patientExisting.setEmail(patient.getEmail());
        patientExisting.setPhoneNumber(patient.getPhoneNumber());
        patientExisting.setBirthDate(patient.getBirthDate());
        patientExisting.setMutuelle(patient.getMutuelle());
        patientExisting.setInfo_supplement(patient.getInfo_supplement());
        patientExisting.setAddress(patient.getAddress());

        return patientRepository.save(patientExisting);
    }

    @Override
    public void deletePatient(Patient patient) {
        if (patient == null || !patientRepository.existsById(patient.getId())) {
            throw new IllegalArgumentException("Patient inexistant");
        }
        patientRepository.delete(patient);
    }
}
