package ro.ciprian.curs.configuration.ciprian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.ciprian.curs.model.Car;
import ro.ciprian.curs.repository.MemoryRepository;

@Configuration
@Profile("ciprian")
public class CarRepositoryConfigCiprian {
    @Bean
    public void loadDataDev() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setMaker("Audi");
        car1.setColor("green");
        car1.setModel("A8");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setMileage(1000);
        car1.setPrice(BigDecimal.valueOf(1727420));
        list.add(car1);

        MemoryRepository.carList=list;
    }
}
