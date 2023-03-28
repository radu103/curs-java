package com.andrei.curs.configuration.dev;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andrei.curs.model.Car;
import com.andrei.curs.repository.MemoryRepository;

@Configuration
@Profile("dev")
public class CarRepositoryConfigDev {

    @Bean
    public void loadDataDev() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setId(1);
        car1.setMaker("BMW");
        car1.setColor("yellow");
        car1.setModel("x5");
        car1.setYear(2023);
        car1.setPower(389);
        car1.setTorque(603);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(98000));
        list.add(car1);

        MemoryRepository.carList = list;
    }
}