package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.PrescriptionMedicament;

public interface PresciptionMedicamentRepository extends JpaRepository<PrescriptionMedicament, PrescriptionMedicament.PrescriptionMedicamentId> {
}
