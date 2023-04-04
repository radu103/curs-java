package ro.raffa.curs.configuration.dev;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.raffa.curs.model.Car;
import ro.raffa.curs.repository.MemoryRepository;

@Configuration
@Profile("dev")
public class CarRepositoryConfigDev {

    @Bean
    public void loadDataDev() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setMaker("BMW");
        car1.setColor("yellow");
        car1.setModel("x5");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(98000));
        list.add(car1);

        MemoryRepository.carList = list;
    }
}
