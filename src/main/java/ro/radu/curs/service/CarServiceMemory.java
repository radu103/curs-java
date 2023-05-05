package ro.radu.curs.service;

import java.util.List;

import ro.radu.curs.model.Car;

public interface CarServiceMemory {
    List<Car> getExpensiveCars(Integer percent);
    List<Car> getOldCars(Integer year);
    List<Car> getTunedCars(Integer Hp);
}