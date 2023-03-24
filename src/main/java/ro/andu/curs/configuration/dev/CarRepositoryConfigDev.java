package ro.andu.curs.configuration.dev;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.andu.curs.model.Car;
import ro.andu.curs.repository.MemoryRepository;

@Configuration
@Profile("dev") //mvn spring-boot:run -Dspring-boot.run.profiles=dev
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
        car1.setPrice(BigDecimal.valueOf(90000));
        list.add(car1);

        MemoryRepository.carList=list;
    }
}
