package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.server.dl.entities.Consultation;

import java.util.List;
import java.util.UUID;

public interface ConsultationRepository extends JpaRepository<Consultation, UUID> {
    // Méthode pour trouver toutes les consultations terminées sans facture
    @Query("SELECT c FROM Consultation c WHERE c.statusRdv = 'TERMINATED' AND c.facture IS NULL")
    List<Consultation> findUnbilledConsultations();
}
