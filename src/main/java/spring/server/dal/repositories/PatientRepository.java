package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.person.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
