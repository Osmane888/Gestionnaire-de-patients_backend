package spring.server.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.server.dl.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
