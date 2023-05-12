package ro.radu.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ro.radu.curs.model.Car;
import ro.radu.curs.repository.CarRepository;

@Service
@Profile("local")
public class CarServiceMemoryImpl implements CarServiceMemory {

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

    public List<Car> getOldCars(Integer year) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setYear(car.getYear() - year);
        }
        return cars;
    }

}