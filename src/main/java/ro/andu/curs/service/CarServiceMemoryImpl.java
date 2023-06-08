package ro.andu.curs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ro.andu.curs.configuration.database.CarRepositoryConfigDtb;
import ro.andu.curs.configuration.dev.CarRepositoryConfigDev;
import ro.andu.curs.configuration.local.CarRepositoryConfigLocal;
import ro.andu.curs.exception.CarServiceException;
import ro.andu.curs.exception.CarValidatorException;
import ro.andu.curs.model.Car;
import ro.andu.curs.repository.CarRepository;
import ro.andu.curs.repository.DbCarRepository;
import ro.andu.curs.repository.DbMemoryRepository;
import ro.andu.curs.repository.MemoryRepository;
import ro.andu.curs.validator.CarValidator;

@Service
public class CarServiceMemoryImpl implements CarServiceMemory{
    
    @Autowired
    CarRepository carRepository;

    @Autowired
    private Environment env;

    public List<Car> getExpensiveCars(Integer percent) throws CarServiceException{
        // if (percent > 100) {
        //     throw new CarServiceException(400, "Percent must be less then 100");
        // } // nu stiu de ce da eroare
        List<Car> cars =  DbCarRepository.getLocalAllCars();
        if (cars == null || cars.isEmpty()) {
            throw new CarServiceException(500, "No cars found");
        }
        for (int i=0;i<cars.size();i++) {
            try {
                CarValidator.validateCarMaker(cars.get(i).getMaker());
            } catch (CarValidatorException e) {
                throw new CarServiceException(e.getErrorCode(), e.getMessage());
            }
        }
        if (cars.size() > 1000) {
            throw new CarServiceException(300, "Too many cars");
        }
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
        List<Car> cars = DbCarRepository.getLocalAllCars();
        for (Car car : cars) {
            car.setPrice(car.getPrice().divide(BigDecimal.valueOf(percent)));
        }
        return cars;
    }
    @Autowired
    DbCarRepository dbCarRepository;

    public void reset() {
        for (String activeProfile : env.getActiveProfiles()) {
            if (activeProfile.equals("local")) {
                new CarRepositoryConfigLocal().loadDataLocal();
            } else if (activeProfile.equals("dev")) {
                new CarRepositoryConfigDev().loadDataDev();
            } else if (activeProfile.equals("dtb")) {
                DbMemoryRepository.carList=dbCarRepository.findAll();
            }
        } 
    }

    public void addCars(String maker, String model, String color, Integer year, Integer price) {
        Car car = new Car();
        car.setMaker(maker);
        car.setColor(color);
        car.setModel(model);
        car.setYear(year);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(price));
        
        MemoryRepository.carList.add(car);
    }
}
