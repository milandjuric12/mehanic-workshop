package mehanicworkshop.dao;

import mehanicworkshop.model.Car;
import mehanicworkshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarDao {

    private final CarRepository carRepository;

    @Autowired
    public CarDao(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Collection<Car> findAll(){
        return this.carRepository.findAll();
    }

    public Optional<Car> findByUuid(final UUID carUuid){
        return this.carRepository.findByUuid(carUuid);
    }

    public Optional<Car> findById(final Long id){
        return this.carRepository.findById(id);
    }

    public Car save(final Car car){
        return this.carRepository.save(car);
    }

    public void deleteById(final Long id){
        this.carRepository.deleteById(id);
    }

    public Optional<Car> findByCustomerUuid(final UUID customerUuid){
        return this.carRepository.findByCustomerUuid(customerUuid);
    }

}
