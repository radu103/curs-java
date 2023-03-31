package ro.ciprian.curs.repository;

import org.springframework.stereotype.Repository;

import ro.ciprian.curs.model.Car;

import java.util.List;

@Repository
public class CarRepository {

    public List<Car> getAllCars() {
        return MemoryRepository.carList;
    }
}
