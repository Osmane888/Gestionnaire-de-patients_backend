package spring.server.api.models.dtos.consultationDTO;

import spring.server.dl.entities.Address;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.enums.StatusRdv;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public record BasicConsultationInfosDTO(

        UUID id,
        LocalDate dateRdv,
        Timestamp hourRdv,
        StatusRdv statusRDV,
        Patient patient
) {


//    public static BasicConsultationInfosDTO fromBasicConsultationInfos(Consultation consultation){
//        return new BasicConsultationInfosDTO(
//                consultation.getId(),
//                consultation.getDateRdv(),
//                consultation.getHourRdv()
//        );
//    }
}
