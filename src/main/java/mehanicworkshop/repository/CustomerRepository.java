package mehanicworkshop.repository;

import mehanicworkshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c from Customer c WHERE c.customerUuid = :uuid")
    Collection<Customer> findAllByUuid(@Param("uuid") final UUID uuid);

    @Query("SELECT c from Customer c WHERE c.customerUuid = :uuid")
    Optional<Customer> findByUuid(@Param("uuid") final UUID uuid);

}
