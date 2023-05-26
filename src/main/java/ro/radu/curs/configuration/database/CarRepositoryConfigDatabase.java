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

@Configuration
@Profile("database")
public class CarRepositoryConfigDatabase {

    @Autowired
    DbCarRepository carRepository;

    @Bean
    public void loadData() {
        long noCars = carRepository.count();
        if (noCars == 0) {
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                cars.add(createCar(i));
            }
            carRepository.saveAll(cars);
        }
    }

    private Car createCar(Integer i) {
        Car car = new Car();
        car.setMaker("Toyota");
        car.setColor("black");
        car.setModel("supra");
        car.setYear(2023 + i);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(75000));
        car.setActive(true);
        return car;
    }
}