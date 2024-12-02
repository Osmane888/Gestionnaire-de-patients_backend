package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.server.dl.entities.Document;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
