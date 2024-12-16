package spring.server.api.models.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.enums.StatusRdv;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record ConsultationForm(
        @NotNull(message = "Select Patient") UUID patientid,
        @NotNull(message = "Appointment date is required") LocalDate dateRdv,
        @NotNull(message = "Appointment Hour") LocalTime hourRdv,
        @NotNull(message = "Appointment Duration") LocalTime durationRdv,
        @NotNull(message = "Appointment status") StatusRdv statusRdv,
        @NotBlank(message = "appointmentType") String rdvType
) {
    public Consultation toConsultation( ) {
        return new Consultation(
                hourRdv,
                dateRdv,
                durationRdv,
                statusRdv,
                rdvType
        );
    }
}
