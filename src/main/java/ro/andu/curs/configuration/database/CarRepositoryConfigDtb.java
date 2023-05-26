package ro.andu.curs.configuration.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.andu.curs.model.Car;
import ro.andu.curs.repository.DbCarRepository;
import ro.andu.curs.repository.DbMemoryRepository;

@Configuration
@Profile("dtb")
public class CarRepositoryConfigDtb {
    @Autowired
    DbCarRepository carRepository;

    @Bean
    public void loadDataDev() {
        List<Car> list = new ArrayList<>();

        list = carRepository.findAll();
        if (list.isEmpty()) {
            Car car1 = new Car();
            car1.setMaker("Ford");
            car1.setColor("black");
            car1.setModel("Mustang");
            car1.setYear(2023);
            car1.setCurrency("EUR");
            car1.setPrice(BigDecimal.valueOf(100000));
            list.add(car1);
        }
        DbMemoryRepository.carList=list;
    }
}
