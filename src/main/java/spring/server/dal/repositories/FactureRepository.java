package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.Facture;

import java.util.UUID;

public interface FactureRepository extends JpaRepository<Facture, UUID> {
}
