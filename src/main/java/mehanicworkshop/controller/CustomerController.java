package mehanicworkshop.controller;

import com.fasterxml.jackson.annotation.JsonView;
import mehanicworkshop.model.Customer;
import mehanicworkshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value="/customer", produces="application/json")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.OPTIONS,
        RequestMethod.PUT
})
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }


    @Transactional(readOnly=true)
    @GetMapping(value = "/{uuid}")
    @ResponseBody
    public Collection<Customer> findAllByUuid(@PathVariable("uuid") final UUID uuid ){
        return this.customerService.findAll(uuid);
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "search/{id}")
    @ResponseBody
    public Optional<Customer> findById(@PathVariable("id") final Long id){
        return this.customerService.findById(id);
    }

    @Transactional
    @PostMapping(value = "")
    @ResponseBody
    public Customer save(@RequestBody final Customer customer){
        return this.customerService.save(customer);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") final Long id){
        this.customerService.deleteById(id);
    }

    @PutMapping(value = "")
    @ResponseBody
    public Customer update(@RequestBody Customer customer){
        return this.customerService.update(customer);
    }
}
