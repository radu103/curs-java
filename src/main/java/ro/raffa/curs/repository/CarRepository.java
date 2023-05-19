package ro.raffa.curs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ro.raffa.curs.model.Car;

/**
 * CarRepository from memory
 */
@Repository
public class CarRepository {

    /**
     * Get all cars
     * 
     * @return {List<Car>}
     */
    public List<Car> getAllCars() {
        return MemoryRepository.carList;
    }
}