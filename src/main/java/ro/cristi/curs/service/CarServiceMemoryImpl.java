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
        List<Car> cars = carRepository.getAllCars();
        if(percent > 100){
            throw new CarServiceException(400, "Percent must be less");
        }
        if (cars == null || cars.isEmpty()) {
            throw new CarServiceException(500, "No cars found");
        }
        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf((100 + percent) / 100)));
        }
        return cars;
    }
}