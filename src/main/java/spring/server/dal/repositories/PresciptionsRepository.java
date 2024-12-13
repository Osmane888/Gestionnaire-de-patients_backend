package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.server.dl.entities.Prescriptions;

import java.util.UUID;

@Repository
public interface PresciptionsRepository extends JpaRepository<Prescriptions, UUID> {
}
