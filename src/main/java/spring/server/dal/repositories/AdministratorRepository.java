package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.person.Administrator;

import java.util.UUID;

public interface AdministratorRepository extends JpaRepository<Administrator, UUID> {
}
