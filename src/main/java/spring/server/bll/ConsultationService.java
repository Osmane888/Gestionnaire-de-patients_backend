package spring.server.bll;

import spring.server.dl.entities.Consultation;

import java.util.List;
import java.util.UUID;

public interface ConsultationService {


    List<Consultation> findAllConsultation();

    Consultation findConsultationById(UUID id);

    Consultation createConsultation(Consultation consultation, UUID patientId);

    Consultation updateConsultation(Consultation consultation);

    void deleteConsultation(Consultation consultation);

}