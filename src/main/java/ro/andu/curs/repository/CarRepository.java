package ro.andu.curs.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import ro.andu.curs.model.Car;

@Repository
public class CarRepository {

    public List<Car> getAllCars() {
        return MemoryRepository.carList;
    }
}
