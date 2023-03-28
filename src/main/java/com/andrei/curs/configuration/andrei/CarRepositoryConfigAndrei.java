package com.andrei.curs.configuration.andrei;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andrei.curs.model.Car;
import com.andrei.curs.repository.MemoryRepository;

import java.math.BigDecimal;
import java.util.*;

@Configuration
@Profile("andrei")
public class CarRepositoryConfigAndrei {

    @Bean
    public void loadDataAndrei() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setId(1);
        car1.setMaker("Volkswagen");
        car1.setColor("pearl white");
        car1.setModel("Arteon");
        car1.setYear(2023);
        car1.setPower(300);
        car1.setTorque(400);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(62000));
        list.add(car1);

        Car car2 = new Car();
        car2.setId(2);
        car2.setMaker("Porsche");
        car2.setColor("racing yellow");
        car2.setModel("GT3 RS");
        car2.setYear(2023);
        car2.setPower(518);
        car2.setTorque(464);
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(225250));
        list.add(car2);

        Car car3 = new Car();
        car3.setId(3);
        car3.setMaker("BMW");
        car3.setColor("signal green");
        car3.setModel("M3 CS");
        car3.setYear(2023);
        car2.setPower(473);
        car2.setTorque(550);
        car3.setCurrency("EUR");
        car3.setPrice(BigDecimal.valueOf(118700));
        list.add(car3);

        MemoryRepository.carList = list;
    }
}
