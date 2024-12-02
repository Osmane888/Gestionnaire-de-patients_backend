package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.person.Professional;

import java.util.UUID;

public interface ProfessionalRepository extends JpaRepository<Professional, UUID> {
}
