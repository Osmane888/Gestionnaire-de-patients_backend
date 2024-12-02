package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.Prescriptions;

import java.util.UUID;

public interface PresciptionsRepository extends JpaRepository<Prescriptions, UUID> {
}
