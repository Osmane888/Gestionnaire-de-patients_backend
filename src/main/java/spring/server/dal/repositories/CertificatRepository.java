package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.Certificat;

import java.util.UUID;

public interface CertificatRepository extends JpaRepository<Certificat, UUID> {
}
