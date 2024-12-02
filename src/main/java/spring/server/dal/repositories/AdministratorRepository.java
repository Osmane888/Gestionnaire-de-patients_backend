package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.server.dl.entities.person.Administrator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdministratorRepository extends JpaRepository<Administrator, UUID> {

    @Query("select count(a) > 0 from Administrator a where a.email ilike :email")
    boolean existsByEmail(String email);

    @Query("select a from Administrator a where a.email ilike :email")
    Optional<Administrator> findByEmail(String email);
}