package ro.andu.curs.configuration.andu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.andu.curs.model.Car;
import ro.andu.curs.repository.MemoryRepository;

@Configuration
@Profile("andu")
public class CarRepositoryConfigAndu {
    @Bean
    public void loadDataDev() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setMaker("Ford");
        car1.setColor("black");
        car1.setModel("Mustang");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(100000));
        list.add(car1);

        MemoryRepository.carList=list;
    }
}
