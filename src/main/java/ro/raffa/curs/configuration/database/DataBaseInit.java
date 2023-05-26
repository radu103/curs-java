package ro.raffa.curs.configuration.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    public void DbInit() {
        if (carRepository.count() == 0) {
            loadDb();
        }

    }

    private void loadDb() {
        ArrayList<Car> list=new ArrayList();
        list.add(createCar("Mercedes", "Red", "CN2", 2020, "EUR", 250000));
        list.add(createCar("BMW", "Cream", "M2", 2023, "EUR", 300000));
        list.add(createCar("Toyota", "Dark Chocolate", "Heisenberg", 2018, "EUR", 80000));
        carRepository.saveAll(list);
    }

    private Car createCar(String maker, String color, String model, Integer year, String currency, Integer price) {
        Car car = new Car();
        car.setMaker(maker);
        car.setColor(color);
        car.setModel(model);
        car.setYear(year);
        car.setCurrency(currency);
        car.setPrice(BigDecimal.valueOf(price));
        car.setActive(true);
        return car;
    }

}