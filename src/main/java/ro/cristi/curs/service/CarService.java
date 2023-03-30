package ro.cristi.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.cristi.curs.Repository.CarRepository;
import ro.cristi.curs.model.Car;
@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    
    public List<Car> getExpensiveCars(Integer percent){

        List<Car> cars = carRepository.getAllCars();
        for(Car car : cars){
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf(percent)));
        }
        return cars;
    }

    public List<Car> getOlderCars(Integer years){

        List<Car> cars = carRepository.getAllCars();
        for(Car car : cars){
            car.setYear(car.getYear() - years);
        }
        return cars;
    }

    public List<Car> getEfficientCars(Integer units){

        List<Car> cars = carRepository.getAllCars();
        for(Car car : cars){
            car.setConsumption(car.getConsumption() - units);
        }
        return cars;
    } 

}
