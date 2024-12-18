package spring.server.bll;

import spring.server.dl.entities.person.Professional;

import java.util.List;
import java.util.UUID;

public interface ProfessionalService {

    List<Professional> findAllProfessional();

    Professional findPatientById(UUID id);

//    Professional createProfessional(Professional professional);

    void deleteProfessional(Professional professional);


}
