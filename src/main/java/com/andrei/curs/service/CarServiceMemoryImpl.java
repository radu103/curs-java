package com.andrei.curs.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.andrei.curs.exception.CarServiceException;
import com.andrei.curs.model.Car;
import com.andrei.curs.repository.CarRepository;

@Service
@Profile("local")
public class CarServiceMemoryImpl implements CarServiceMemory {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getExpensiveCars(Integer percent) throws CarServiceException {

        List<Car> cars = carRepository.getAllCars();
        if (cars.size() > 999) {
            throw new CarServiceException(356, "The number of cars need to be less than 1000");
        }

        if (percent > 100) {
            throw new CarServiceException(400, "Percent must be less than 100");
        }

        if (cars == null || cars.isEmpty()) {
            throw new CarServiceException(500, "No cars found");
        }
        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf((100 + percent) / 100)));
        }
        return cars;
    }

    @Override
    public List<Car> getOldCars(Integer val) {
        List<Car> cars = carRepository.getAllCars();
        if (val > 5) {
            throw new CarServiceException(357, "The number of years needs to be less than 6");
        }
        for (Car car : cars) {
            car.setYear(car.getYear() - val);
        }

        return cars;
    }

    @Override
    public List<Car> getTunedCar(Integer stage, Integer carId) {
        List<Car> cars = carRepository.getAllCars();
        if (stage > 3) {
            throw new CarServiceException(358, "Stage needs to be less than 4");
        }
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                Integer nr;
                switch (stage) {
                    case 1:
                        nr = 25;
                        break;
                    case 2:
                        nr = 50;
                        break;
                    default:
                        nr = stage % 10 * 20;
                }
                car.setPower(car.getPower() + nr);
            }
        }

        return cars;
    }
}