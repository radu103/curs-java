package ro.radu.curs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ro.radu.curs.model.Car;

@Repository
public class CarRepository {

    public List<Car> getAllCars() {
        return MemoryRepository.carList;
    }
}
