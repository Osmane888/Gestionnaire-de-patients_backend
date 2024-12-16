package spring.server.api.models.dtos.consultationDTO;

import spring.server.dl.entities.Address;
import spring.server.dl.entities.Certificat;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.Facture;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.StatusRdv;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record TotalConsultationInfosDTO(

        UUID id,
        LocalDate dateRdv,
        LocalTime hourRdv,
        Address address,
        LocalTime durationRdv,
        StatusRdv statusRDV,
        String rdvType,
        String consigne,
        UUID patientid,              // Utilisation de l'UUID pour le patient
        Professional professional,
        Facture facture,
        Certificat certificat

) {

    // Méthode pour transformer une entité Consultation en DTO
    public static TotalConsultationInfosDTO fromTotalConsultationInfos(Consultation consultation) {
        return new TotalConsultationInfosDTO(
                consultation.getId(),
                consultation.getDateRdv(),
                consultation.getHourRdv(),
                consultation.getAddress(),
                consultation.getDurationRdv(),
                consultation.getStatusRdv(),
                consultation.getRdvType(),
                consultation.getConsigne(),
                consultation.getPatient() != null ? consultation.getPatient().getId() : null,
                consultation.getProfessional(),
                consultation.getFacture(),
                consultation.getCertificat()
        );
    }
}
