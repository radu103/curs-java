package ro.cristi.curs.service;

import java.util.List;

import ro.cristi.curs.model.Car;

public interface CarServiceMemory {
    List<Car> getExpensiveCars(Integer percent);

    List<Car> getOlderCars(Integer years);

    List<Car> getEfficientCars(Integer units);
}
