package ro.cristi.curs.configuration.database;

import java.math.BigDecimal;

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

        Car car = new Car();
        car.setColor("green");
        car.setIsManual(true);
        car.setMaker("Dacia");
        car.setModel("Noul Logan");
        car.setConsumption(6.9);
        car.setYear(2022);
        car.setPrice(BigDecimal.valueOf(16400));
        car.setCurrency("EUR");
        carRepository.save(car);

        Car car2 = new Car();
        car2.setColor("yellow");
        car2.setMaker("BMW");
        car2.setIsManual(false);
        car2.setYear(2023);
        car2.setConsumption(12.0);
        car2.setModel("x5");
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(980000));
        carRepository.save(car2);
        }
    }
}
