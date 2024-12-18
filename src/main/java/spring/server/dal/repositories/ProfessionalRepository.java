package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.server.dl.entities.person.Professional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, UUID> {

    @Query("select count(p) > 0 from Professional p where p.email ilike :email")
    boolean existsByEmail(String email);

    @Query("select p from Professional p where p.email ilike :email")
    Optional<Professional> findByEmail(String email);

    @Query("select count(p) > 0 from Professional p WHERE p.lastName = :lastName and p.firstName = :firstName")
    boolean existsByAppelation(String lastName, String firstName);

}
