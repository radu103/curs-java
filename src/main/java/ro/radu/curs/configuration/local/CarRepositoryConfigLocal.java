package ro.radu.curs.configuration.local;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.radu.curs.model.Car;
import ro.radu.curs.repository.MemoryRepository;

@Configuration
@Profile("local")
public class CarRepositoryConfigLocal {

    @Bean
    public void loadData() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setMaker("BMW");
        car1.setColor("yellow");
        car1.setModel("x5");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(98000));
        car1.setHp(150);
        list.add(car1);

        Car car2 = new Car();
        car2.setMaker("Nissan");
        car2.setColor("Blue");
        car2.setModel("r34 gtr");
        car2.setYear(1999);
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(56000));
        car2.setHp(280);
        list.add(car2);

        MemoryRepository.carList = list;
    }
}
