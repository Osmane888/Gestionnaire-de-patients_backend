package spring.server.api.controllers.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.api.models.dtos.consultationDTO.TotalConsultationInfosDTO;
import spring.server.api.models.dtos.patientDTO.TotalInfosDTO;
import spring.server.bll.ConsultationService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultation")
@CrossOrigin("*")
public class ConsultationController {

    private final ConsultationService consultationService;

    @GetMapping("/{id}")
    public ResponseEntity<TotalConsultationInfosDTO> findById(@PathVariable UUID id) {

        TotalConsultationInfosDTO dto = TotalConsultationInfosDTO.fromTotalConsultationInfos(consultationService.findConsultationById(id));
        return ResponseEntity.ok(dto);
    }
}
