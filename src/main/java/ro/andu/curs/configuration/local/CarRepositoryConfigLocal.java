package ro.andu.curs.configuration.local;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.andu.curs.model.Car;
import ro.andu.curs.repository.MemoryRepository;

@Configuration
@Profile("local") //mvn spring-boot:run -Dspring-boot.run.profiles=local
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
        car1.setPrice(BigDecimal.valueOf(90000));
        list.add(car1);
        
        Car car2 = new Car();
        car2.setMaker("Mercedes");
        car2.setColor("red");
        car2.setModel("GLE");
        car2.setYear(2023);
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(120000));
        list.add(car2);
        
        Car car3 = new Car();
        car3.setMaker("Ford");
        car3.setColor("black");
        car3.setModel("Mustang");
        car3.setYear(2023);
        car3.setCurrency("EUR");
        car3.setPrice(BigDecimal.valueOf(85000));
        list.add(car3);

        MemoryRepository.carList=list;
    }
}
