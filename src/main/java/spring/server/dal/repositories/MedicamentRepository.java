package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.Medicament;

import java.util.UUID;

public interface MedicamentRepository extends JpaRepository<Medicament, UUID> {
}
