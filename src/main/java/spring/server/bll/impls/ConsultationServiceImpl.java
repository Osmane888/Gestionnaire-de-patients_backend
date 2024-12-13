package spring.server.bll.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.server.bll.ConsultationService;
import spring.server.dal.repositories.ConsultationRepository;
import spring.server.dl.entities.Consultation;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;

    @Override
    public List<Consultation> findAllConsultation(){
        return consultationRepository.findAll();
    }

    @Override
    public Consultation findConsultationById(UUID id){
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation createConsultation(Consultation consultation){
       return consultationRepository.save(consultation);
    }


    @Override
    public Consultation updateConsultation(Consultation consultation){
        Consultation consultationExisting = findConsultationById(consultation.getId());
        consultation.setId(UUID.randomUUID());
        consultation.setDurationRdv(consultation.getDurationRdv());
        consultation.setHourRdv(consultation.getHourRdv());
        consultation.setConsigne(consultation.getConsigne());
        consultation.setRdvType(consultation.getRdvType());
        consultation.setAnnulationDelay(consultation.getAnnulationDelay());
        consultation.setDateRdv(consultation.getDateRdv());
        consultation.setPatient(consultation.getPatient());
        consultation.setProfessional(consultation.getProfessional());
        consultation.setFacture(consultation.getFacture());
        consultation.setCertificat(consultation.getCertificat());
        consultation.setStatusRdv(consultation.getStatusRdv());
        return consultationRepository.save(consultationExisting);

    }

    @Override
    public void deleteConsultation(Consultation consultation){

    }
}
