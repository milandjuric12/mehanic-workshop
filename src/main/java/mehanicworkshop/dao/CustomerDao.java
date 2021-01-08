package mehanicworkshop.dao;

import mehanicworkshop.model.Customer;
import mehanicworkshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerDao {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerDao(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Collection<Customer> findAllByUuid(final UUID customerUuid){
        return this.customerRepository.findAllByUuid(customerUuid);
    }

    public Optional<Customer> findByUuid(final UUID customerUuid){
        return this.customerRepository.findByUuid(customerUuid);
    }

    public Optional<Customer> findById(final Long id){
        return this.customerRepository.findById(id);
    }

    public Customer save(final Customer customer){
        return this.customerRepository.save(customer);
    }

    public void deleteById(final Long id){
        this.customerRepository.deleteById(id);
    }

}
