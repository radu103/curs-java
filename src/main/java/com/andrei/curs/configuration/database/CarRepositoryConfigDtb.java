package com.andrei.curs.configuration.database;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andrei.curs.model.Car;
import com.andrei.curs.repository.DbCarRepository;

@Configuration
@Profile("database")
public class CarRepositoryConfigDtb {
    @Autowired
    DbCarRepository carRepository;

    private Car createCar(String maker, String color, String model, Integer power, Integer year, String currency,
            Integer price) {
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

    @Bean
    public void loadDatabase() {
        if (carRepository.count() == 0) {
            carRepository.save(createCar("BMW", "yellow", "x5", 350, 2023, "EUR", 98000));
            carRepository.save(createCar("Mercedes", "red", "GLE", 300, 2020, "EUR", 124000));
            carRepository.save(createCar("Rimac", "blue", "Nevera", 2000, 2021, "EUR", 2000000));
        }
    }
}
