package mehanicworkshop.controller;

import mehanicworkshop.model.Car;
import mehanicworkshop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value="/car", produces="application/json")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.OPTIONS,
        RequestMethod.PUT
})
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "")
    @ResponseBody
    public Collection<Car> findAll(){
        return this.carService.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<Car> findById(@PathVariable("id") final Long id){
        return this.carService.findById(id);
    }

    @PostMapping(value = "")
    @ResponseBody
    public Car save(@RequestBody final Car car){
        return this.carService.save(car);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") final Long id){
        this.carService.deleteById(id);
    }

    @PutMapping(value = "")
    public Car update(@RequestBody final Car car){
        return this.carService.update(car);
    }

}
