package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.person.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    // Méthode pour trouver un patient par email (utile pour l'envoi de factures)
    Optional<Patient> findByEmail(String email);
}
