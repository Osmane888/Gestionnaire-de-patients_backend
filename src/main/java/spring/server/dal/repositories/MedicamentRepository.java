package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.server.dl.entities.Medicament;

import java.util.UUID;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, UUID> {
}
