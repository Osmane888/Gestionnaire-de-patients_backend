package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.server.dl.entities.PrescriptionMedicament;

@Repository
public interface PresciptionMedicamentRepository extends JpaRepository<PrescriptionMedicament, PrescriptionMedicament.PrescriptionMedicamentId> {
}
