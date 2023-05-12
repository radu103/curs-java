package ro.andu.curs.service;

import java.util.List;

import ro.andu.curs.model.Car;

public interface CarServiceMemory {
    List<Car> getExpensiveCars(Integer percent);

    List<Car> getOlderCars(Integer value);

    List<Car> getCheaperCars(Integer value);

    void addCars(String maker, String model, String color, Integer year, Integer price);

    void reset();
}
