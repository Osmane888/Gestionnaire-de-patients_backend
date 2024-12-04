package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.server.dl.entities.person.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query("select a from Patient a where a.firstName = :firstname and a.lastName = :lastname")
    Optional<Patient> findByAppelation(String firstname, String lastname);

    @Query("select count(a) > 0 from Patient a where a.firstName = :firstname and a.lastName = :lastname")
    boolean existsByAppelation(String firstname, String lastname);
}
