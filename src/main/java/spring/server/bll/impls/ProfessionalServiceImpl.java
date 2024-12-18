package spring.server.bll.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.server.bll.ProfessionalService;
import spring.server.dal.repositories.ProfessionalRepository;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalRepository professionalRepository;

    @Override
    public List<Professional> findAllProfessional() {
        return professionalRepository.findAll();
    }

    @Override
    public Professional findPatientById(UUID id) {
        return professionalRepository.findById(id).orElse(null);
    }

//    @Override
//    public Professional createProfessional(Professional professional) {
//        if(professionalRepository.existsByAppelation(professional.getLastName(), professional.getFirstName())) {
//            throw new IllegalArgumentException("Le professionel existe déjà");
//        }
//        if (professional.getLastName() == null) {
//            throw new IllegalArgumentException("Address is required.");
//        }
//        professional.setId(UUID.randomUUID());
//
//        return professionalRepository.save(professional);
//    }

    @Override
    public void deleteProfessional(Professional professional){
        if (professional == null || !professionalRepository.existsById(professional.getId())) {
            throw new IllegalArgumentException("Professional inexistant");
        }
        professionalRepository.delete(professional);
    }

}
