package spring.server.bll.impls;

import org.springframework.stereotype.Service;
import spring.server.bll.ConsultationService;
import spring.server.dal.repositories.ConsultationRepository;
import spring.server.dl.entities.Consultation;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;

    public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<Consultation> getUnbilledConsultations() {
        return consultationRepository.findUnbilledConsultations();
    }

    @Override
    public Consultation findById(UUID id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation introuvable"));
    }

    @Override
    public Consultation save(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}

