package ro.radu.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ro.radu.curs.exception.CarServiceException;
import ro.radu.curs.model.Car;
import ro.radu.curs.repository.CarRepository;

@Service
@Profile("local")
public class CarServiceMemoryImpl implements CarServiceMemory {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getExpensiveCars(Integer percent) throws CarServiceException {
        List<Car> cars = carRepository.getAllCars();

        if (percent > 100) {
            throw new CarServiceException(40001, "Percent must be less then 100");
        }

        if (cars == null || cars.isEmpty()) {
            throw new CarServiceException(50001, "No cars found");
        }

        if (cars.size() > 1000) {
            throw new CarServiceException(50002, "Too many cars");
        }

        for (Car car : cars) {
            car.setPrice(car.getPrice().multiply(BigDecimal.valueOf((100 + percent) / 100)));
        }
        return cars;
    }
}
