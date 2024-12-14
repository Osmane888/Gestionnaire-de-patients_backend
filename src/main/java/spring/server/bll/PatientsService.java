package spring.server.bll;

import spring.server.dl.entities.person.Patient;

import java.util.UUID;

public interface PatientsService {

    Patient findPatientById(UUID id);
}
