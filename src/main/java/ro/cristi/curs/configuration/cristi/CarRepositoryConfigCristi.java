package ro.cristi.curs.configuration.cristi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.cristi.curs.Repository.MemoryRepository;
import ro.cristi.curs.model.Car;

@Configuration
@Profile("cristi")
public class CarRepositoryConfigCristi {
    public void loadDataCristi() {
        List<Car> list = new ArrayList<>();

        Car car = new Car();
        car.setColor("green");
        car.setIsManual(true);
        car.setMaker("Dacia");
        car.setModel("Noul Logan");
        car.setConsumption(6.9);
        car.setYear(2022);
        car.setPrice(BigDecimal.valueOf(16400));
        car.setCurrency("EUR");
        list.add(car);

        Car car2 = new Car();
        car2.setColor("yellow");
        car2.setMaker("BMW");
        car2.setIsManual(false);
        car2.setYear(2023);
        car2.setConsumption(12.0);
        car2.setModel("x5");
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(980000));
        list.add(car2);

        MemoryRepository.carList = list;
    }
}
