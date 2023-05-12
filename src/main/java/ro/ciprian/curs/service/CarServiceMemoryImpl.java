package ro.ciprian.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.ciprian.curs.exception.CarServiceException;
import ro.ciprian.curs.model.Car;
import ro.ciprian.curs.repository.CarRepository;

@Service
public class CarServiceMemoryImpl implements CarServiceMemory {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getExpensiveCars(Integer percent) throws CarServiceException {
        List<Car> cars = carRepository.getAllCars();

        if(cars.size()>1000){
            throw new CarServiceException(600, "Too many cars(over 1k)");
        }

        if(percent>100) {
            throw new CarServiceException(400, "Percent must be less than 100");
        }

        if(cars == null || cars.isEmpty()) {
            throw new CarServiceException(500,"NO CARS FOUND!!!");
        }

        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf((100 + percent) / 100)));
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
            car.setPrice(car.getPrice().divide(BigDecimal.valueOf(1 + (percent / 100))));
        }
        return cars;
    }
}
