package ro.ciprian.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.ciprian.curs.model.Car;
import ro.ciprian.curs.repository.CarRepository;

@Service
public class CarServiceMemoryImpl implements CarServiceMemory {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getExpensiveCars(Integer percent) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf(percent)));
        }
        return cars;
    }

    @Override
    public List<Car> getOlderCars(Integer value) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setYear(car.getYear() - value);
        }
        return cars;
    }

    @Override
    public List<Car> getCheaperCars(Integer percent) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setPrice(car.getPrice().divide(BigDecimal.valueOf(percent)));
        }
        return cars;
    }
}
