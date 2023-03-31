package ro.ciprian.curs.service;

import java.util.List;

import ro.ciprian.curs.model.Car;

public interface CarServiceMemory {

    List<Car> getExpensiveCars(Integer percent);

    List<Car> getOlderCars(Integer value);

    List<Car> getCheaperCars(Integer percent);

}