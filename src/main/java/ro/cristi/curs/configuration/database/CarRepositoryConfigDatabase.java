package ro.cristi.curs.configuration.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.cristi.curs.model.Car;
import ro.cristi.curs.repository.DbCarRepository;

@Configuration
@Profile("database")
public class CarRepositoryConfigDatabase {
    
    @Autowired
    DbCarRepository carRepository;

    @Bean
    public void LoadDataDb() {
        if(carRepository.findAll().isEmpty()){

            List<Car> cars = new ArrayList<Car>();

            for(int i = 1; i<=50; i++){

                cars.add(createCar("Dacia", "green", "Noul Logan", true, 
                6.9, 2022, "EUR", BigDecimal.valueOf(16400)));
                cars.add(createCar("BMW", "yellow", "x5", false,
                12.0, 2023, "EUR", BigDecimal.valueOf(980000)));
                }

            carRepository.saveAll(cars);
            }
    }

    private Car createCar(String maker, String color, String model, 
        Boolean isManual, Double consumption, Integer year, String currency,BigDecimal price) {
        
        Car car = new Car();
        car.setMaker(maker);
        car.setColor(color);
        car.setModel(model);
        car.setYear(year);
        car.setCurrency(currency);
        car.setPrice(price);
        car.setActive(true);
        car.setConsumption(consumption);
        car.setIsManual(isManual);
        return car;
    }

}
