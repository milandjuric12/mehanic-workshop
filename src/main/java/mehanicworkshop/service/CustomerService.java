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
public class CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(final CustomerDao customerDao) {
        this.customerDao = customerDao;

    }

    public Collection<Customer> findAll(UUID customerUuid){
        return this.customerDao.findAllByUuid(customerUuid);
    }

    public Optional<Customer> findByUuid(final UUID customerUuid){
        return this.customerDao.findByUuid(customerUuid);
    }

    public Optional<Customer> findById(final Long id){
        return this.customerDao.findById(id);
    }

    public Customer save(final Customer customer){
        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(0L);
        newCustomer.setCustomerUuid(UUID.randomUUID());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setFullName(customer.getFullName());
        newCustomer.setNumber(customer.getNumber());
        return this.customerDao.save(newCustomer);
    }

    public void deleteById(final Long id){
        this.customerDao.deleteById(id);
    }

    public Customer update(final Customer customer){
        Optional<Customer> customerOptional =
                this.customerDao.findByUuid(customer.getCustomerUuid());
        if(customerOptional.isPresent()){
            customerOptional.ifPresent(c ->{
                c.setFullName(customer.getFullName());
                c.setNumber(customer.getNumber());
                c.setEmail(customer.getEmail());
                c.setAddress(customer.getAddress());
            });
            return this.customerDao.save(customerOptional.get());
        }
        else{
            return null;
        }
    }
}
