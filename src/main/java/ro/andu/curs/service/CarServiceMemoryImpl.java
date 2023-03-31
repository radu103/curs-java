package ro.andu.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.andu.curs.model.Car;
import ro.andu.curs.repository.CarRepository;

@Service
public class CarServiceMemoryImpl implements CarServiceMemory{
    
    @Autowired
    CarRepository carRepository;

    public List<Car> getExpensiveCars(Integer percent) {
        List<Car> cars =  carRepository.getAllCars();
        for(Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf((100 + percent)/100)));
        }
        return cars;
    }

    public List<Car> getOlderCars(Integer value) {
        List<Car> cars = carRepository.getAllCars();
        for(Car car : cars) {
            car.setYear(car.getYear()-value);
        }
        return cars;
    }
    
    public List<Car> getCheaperCars(Integer percent) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setPrice(car.getPrice().divide(BigDecimal.valueOf(percent)));
        }
        return cars;
    }
}
