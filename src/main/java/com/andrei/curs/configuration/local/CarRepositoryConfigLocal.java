package com.andrei.curs.configuration.local;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andrei.curs.model.Car;
import com.andrei.curs.repository.MemoryRepository;

@Configuration
@Profile("local")
public class CarRepositoryConfigLocal {

    @Bean
    public void loadDataLocal() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setId(1);
        car1.setPower(300);
        car1.setMaker("BMW");
        car1.setColor("yellow");
        car1.setModel("x5");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(98000));
        list.add(car1);

        Car car2 = new Car();
        car2.setId(2);
        car2.setPower(350);
        car2.setMaker("Mecedes");
        car2.setColor("red");
        car2.setModel("GLE");
        car2.setYear(2020);
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(124000));
        list.add(car2);

        Car car3 = new Car();
        car3.setId(2);
        car3.setPower(2000);
        car3.setMaker("Rimac");
        car3.setColor("blue");
        car3.setModel("Nevera");
        car3.setYear(2021);
        car3.setCurrency("EUR");
        car3.setPrice(BigDecimal.valueOf(2000000));
        list.add(car3);

        MemoryRepository.carList = list;

    }
}
