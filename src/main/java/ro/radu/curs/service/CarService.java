package ro.radu.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ro.radu.curs.model.Car;
import ro.radu.curs.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getExpensiveCars(Integer percent) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf(percent)));
        }
        return cars;
    }

    public List<Car> getOldCars(Integer year) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setYear(car.getYear() - year);
        }
        return cars;
    }

    public List<Car> getTunedCars(Integer Hp) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setHp(car.getHp() + Hp);
        }
        return cars;
    }
}
