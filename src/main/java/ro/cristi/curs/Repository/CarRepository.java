package ro.cristi.curs.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ro.cristi.curs.model.Car;

@Repository
public class CarRepository {

    public List<Car> getAllCars(){
        return MemoryRepository.carList;
    }
}
