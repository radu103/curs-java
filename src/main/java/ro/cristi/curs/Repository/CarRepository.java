package ro.cristi.curs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ro.cristi.curs.model.Car;

/**
 * CarRepository from memory
 */

@Repository
public class CarRepository {
    /**
     * Get all car
     * 
     * @return {list<car>}
     */


    public List<Car> getAllCars(){
        return MemoryRepository.carList;
    }
}
