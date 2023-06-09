package ro.radu.curs.configuration.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.radu.curs.model.Car;
import ro.radu.curs.repository.DbCarRepository;
import ro.radu.curs.repository.MemoryRepository;

@Configuration
@Profile("database")
public class CarRepositoryConfigDatabase {

    @Autowired
    DbCarRepository carRepository;


    @Bean
    public void loadData() {
        if(carRepository.findAll().isEmpty()){
        for(int i=0; i<10; i++){
        Car car1 = new Car();
        car1.setMaker("Toyota");
        car1.setColor("black");
        car1.setModel("supra");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(75000));
        car1.setHp(400);
        
        carRepository.save(car1);
        }

        }
    }

}
