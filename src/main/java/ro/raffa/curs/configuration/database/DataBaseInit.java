package ro.raffa.curs.configuration.database;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.raffa.curs.model.Car;
import ro.raffa.curs.repository.DbCarRepository;

@Configuration
@Profile("database")
public class DataBaseInit {
    @Autowired
    DbCarRepository carRepository;

    @Bean 
    public void DbInit(){
        if(carRepository.count()==0){
            loadDb();
        }

    }

    private void loadDb() {
        carRepository.save(createCar("Mercedes","Red", "CN2", 2020, "EUR", 250000));
        carRepository.save(createCar("BMW", "Cream", "M2", 2023, "EUR", 300000));
        carRepository.save(createCar("Toyota", "Dark Chocolate", "Heisenberg", 2018, "EUR", 80000));
    }

    private Car createCar(String maker,String color,String model, Integer year,  String currency, Integer price) {
        Car car = new Car();
        car.setMaker(maker);
        car.setColor(color);
        car.setModel(model);
        car.setYear(year);
        car.setCurrency(currency);
        car.setPrice(BigDecimal.valueOf(price));
        return car;
    }

}
