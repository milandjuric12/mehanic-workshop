package mehanicworkshop.dao;

import mehanicworkshop.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarDao {

    private final CarRepository carRepository;

    public CarDao(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }


}
