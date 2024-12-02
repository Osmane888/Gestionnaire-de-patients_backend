package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.server.dl.entities.person.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query("select count(a) > 0 from Patient a where a.firstName = :firstname and a.lastName = :lastname")
    boolean existsByFirstnameAndLastname(String firstname, String lastname);

}
