package mehanicworkshop.repository;

import mehanicworkshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.carUuid = uuid")
    Optional<Car> findByUuid(@Param("uuid") final UUID uuid);

    @Query("SELECT c from Car c WHERE c.customer.customerUuid = customerUuid")
    Collection<Car> findByCustomerUuid(@Param("customerUuid") final UUID customerUuid);
}
