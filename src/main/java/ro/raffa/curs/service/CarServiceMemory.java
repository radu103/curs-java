package ro.raffa.curs.service;

import java.util.List;

import ro.raffa.curs.model.Car;

public interface CarServiceMemory {
    List<Car> getExpensiveCars(Integer percent);
}