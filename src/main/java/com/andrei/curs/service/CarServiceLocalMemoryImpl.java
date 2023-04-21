package com.andrei.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.andrei.curs.model.Car;
import com.andrei.curs.repository.CarRepository;

@Service
@Profile("local") // mvn spring-boot:run -Dspring-boot.run.profiles=local
public class CarServiceLocalMemoryImpl implements CarServiceMemory {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getExpensiveCars(Integer percent) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf((100 + percent) / 100)));
        }
        return cars;
    }

    @Override
    public List<Car> getOldCars(Integer v) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setYear(car.getYear() - v);
        }

        return cars;
    }

    @Override
    public List<Car> getTunedCar(Integer step, Integer number) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            if (car.getId().equals(number)) {
                Integer nr;
                switch (step) {
                    case 1:
                        nr = 25;
                        break;
                    case 2:
                        nr = 50;
                        break;
                    default:
                        nr = step % 10 * 20;
                }
                car.setPower(car.getPower() + nr);
            }
        }

        return cars;
    }

    // public static void refreshList(){
    // MemoryRepository memoryRepository;
    // memoryRepository.carList.
    // }
}