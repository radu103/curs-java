package ro.raffa.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.raffa.curs.model.Car;
import ro.raffa.curs.repository.CarRepository;

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

    // TEMA

    public List<Car> increaseStocks(Integer value) {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setNumberInStock(car.getNumberInStock() + value);
        }
        return cars;
    }

    public List<Car> setCarStockEmpty() {
        List<Car> cars = carRepository.getAllCars();
        for (Car car : cars) {
            car.setNumberInStock(0);
        }
        return cars;
    }

    public List<Car> modifyCarStock(String model, Integer value) {
        List<Car> cars = carRepository.getAllCars();
        boolean found = false;
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                car.setNumberInStock(car.getNumberInStock() + value);
                found = !found;
            }
        }
        if (!found) {
            System.out.println(
                    "EXCEPTION: Request for modifyCarStock(String model, Integer value) hasn't found the model name");
        }
        return cars;
    }

}
