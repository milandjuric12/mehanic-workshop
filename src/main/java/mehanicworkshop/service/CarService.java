package mehanicworkshop.service;

import mehanicworkshop.dao.CarDao;
import mehanicworkshop.dao.CustomerDao;
import mehanicworkshop.model.Car;
import mehanicworkshop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    private CarDao carDao;
    private CustomerDao customerDao;

    @Autowired
    public CarService(final CarDao carDao,
                      final CustomerDao customerDao) {
        this.carDao = carDao;
        this.customerDao = customerDao;
    }

    public Collection<Car> findAll(){
        return this.carDao.findAll();
    }

    public Optional<Car> findById(final Long id){
        return this.carDao.findById(id);
    }

    public Optional<Car> findByUuid(final UUID uuid){
        return this.carDao.findByUuid(uuid);
    }

    public Car save(final Car car){
        Car newCar = new Car();
        Optional<Customer> customerOptional =
                this.customerDao.findByUuid(car.getCustomer().getCustomerUuid());
        newCar.setCarId(0L);
        newCar.setCarUuid(UUID.randomUUID());
        newCar.setMark(car.getMark());
        newCar.setModel(car.getModel());
        newCar.setRego(car.getRego());
        if(customerOptional.isPresent()){
            customerOptional.ifPresent(car::setCustomer);
        }
        return this.carDao.save(newCar);
    }

    public void deleteById(final Long id){
        this.carDao.deleteById(id);
    }

    public Car update(final Car car){
        Optional<Car> carOptional =
                this.carDao.findByUuid(car.getCarUuid());
        Optional<Customer> customerOptional =
                this.customerDao.findByUuid(car.getCustomer().getCustomerUuid());
        if(carOptional.isPresent()){
            carOptional.ifPresent(c ->{
                c.setRego(car.getRego());
                c.setModel(car.getModel());
                c.setMark(car.getMark());
                customerOptional.ifPresent(c::setCustomer);
            });
            return this.carDao.save(carOptional.get());
        }
        else{
            return null;
        }
    }

}
