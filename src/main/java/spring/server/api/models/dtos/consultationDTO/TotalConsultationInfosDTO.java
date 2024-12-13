package spring.server.api.models.dtos.consultationDTO;

import spring.server.api.models.dtos.patientDTO.TotalInfosDTO;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.Certificat;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.Facture;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.StatusRdv;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record TotalConsultationInfosDTO(

        UUID id,
        LocalDate dateRdv,
        Timestamp hourRdv,
        Address adress,
        LocalTime durationRdv,
        StatusRdv statusRDV,
        String rdvType,
        String consigne,
        Patient patient,
        Professional professional,
        Facture facture,
        Certificat certificat



) {

    public static TotalConsultationInfosDTO fromTotalConsultationInfos(Consultation consultation){
        return new TotalConsultationInfosDTO(
                consultation.getId(),
                consultation.getDateRdv(),
                consultation.getHourRdv(),
                consultation.getAddress(),
                consultation.getDurationRdv(),
                consultation.getStatusRdv(),
                consultation.getRdvType(),
                consultation.getConsigne(),
                consultation.getPatient(),
                consultation.getProfessional(),
                consultation.getFacture(),
                consultation.getCertificat()

        );
    }
}
