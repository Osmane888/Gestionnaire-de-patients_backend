package spring.server.bll;

import spring.server.dl.entities.person.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientsService {

    List<Patient> findAllPatient();

    Patient findPatientById(UUID id);

    List<Patient> findPatientByLastNameAndFirstName(String lastName, String firstName);

    List<Patient> findPatientByLastNameOrFirstName(String name);

    Patient createPatient(Patient patient);

    Patient updatePatient(Patient patient);

    void deletePatient(Patient patient);
}
