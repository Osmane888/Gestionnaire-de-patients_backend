package spring.server.bll;

import spring.server.dl.entities.Consultation;

import java.util.List;
import java.util.UUID;

public interface ConsultationService {

    // Responsable de la logique métier pour gérer les consultations.
    List<Consultation> getUnbilledConsultations();
    Consultation findById(UUID id);
    Consultation save(Consultation consultation);
}
