package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.server.dl.entities.person.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    // INVERSION LAST ET FIRST NAME, la c'est bon
    @Query("SELECT p FROM Patient p WHERE LOWER(TRIM(p.firstName)) = LOWER(TRIM(:firstName)) AND LOWER(TRIM(p.lastName)) = LOWER(TRIM(:lastName))")
    Optional<Patient> findByLastNameAndFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);


    @Query("select count(a) > 0 from Patient a where a.firstName = :firstname and a.lastName = :lastname")
    boolean existsByAppelation(String lastname, String firstname);

}
