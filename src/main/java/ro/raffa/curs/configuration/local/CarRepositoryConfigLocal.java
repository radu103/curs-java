package ro.raffa.curs.configuration.local;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.raffa.curs.model.Car;
import ro.raffa.curs.repository.MemoryRepository;

@Configuration
@Profile("local")
public class CarRepositoryConfigLocal {

    @Bean
    public void loadDataLocal() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setMaker("BMW");
        car1.setColor("yellow");
        car1.setModel("x5");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(98000));
        list.add(car1);

        Car car2 = new Car();
        car2.setMaker("Mercedes");
        car2.setColor("red");
        car2.setModel("GLE");
        car2.setYear(2020);
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(124000));
        list.add(car2);

        MemoryRepository.carList = list;
    }
}
