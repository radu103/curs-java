package ro.cristi.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ro.cristi.curs.exception.CarServiceException;
import ro.cristi.curs.model.Car;
import ro.cristi.curs.repository.CarRepository;

@Service
@Profile("local")
public class CarServiceMemoryImpl implements CarServiceMemory {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getExpensiveCars(Integer percent) throws CarServiceException {
        
        if(percent > 100){
            throw new CarServiceException(40001, "Percent must be less");
        }
        List<Car> cars = carRepository.getAllCars();
        if (cars == null || cars.isEmpty()) {
            throw new CarServiceException(50001, "No cars found");
        } else if (cars.size()>1000) {
            throw new CarServiceException(50002, "Too many cars found");
        }
        //after error checks
        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf((100 + percent) / 100)));
        }
        return cars;
    }

    @Override
    public List<Car> getOlderCars(Integer years){
        //todo: exceptions
        List<Car> cars = carRepository.getAllCars();
        for(Car car : cars){
            car.setYear(car.getYear() - years);
        }
        return cars;
    }

    @Override
    public List<Car> getEfficientCars(Integer units){
        //todo: exceptions
        List<Car> cars = carRepository.getAllCars();
        for(Car car : cars){
            car.setConsumption(car.getConsumption() - units);
        }
        return cars;
    } 
}