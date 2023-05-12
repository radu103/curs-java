package com.andrei.curs.service;

import java.util.List;

import com.andrei.curs.model.Car;

public interface CarServiceMemory {
    List<Car> getExpensiveCars(Integer percent);

    List<Car> getOldCars(Integer val);

    List<Car> getTunedCar(Integer step, Integer number);

    List<Car> getManyCars(Integer number);
}