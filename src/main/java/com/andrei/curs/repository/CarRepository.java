package com.andrei.curs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.andrei.curs.model.Car;

@Repository
public class CarRepository {

    public List<Car> getAllCars() {
        return MemoryRepository.carList;
    }
}