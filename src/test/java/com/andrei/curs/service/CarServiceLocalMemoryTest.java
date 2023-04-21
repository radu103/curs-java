package com.andrei.curs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.andrei.curs.model.Car;
import com.andrei.curs.repository.CarRepository;

@SpringBootTest
class CarServiceMemoryTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarServiceLocalMemoryImpl carServiceLocalMemoryImpl = new CarServiceLocalMemoryImpl();

    @Autowired
    ObjectMapper objectMapper;

    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = getAllCars();
        when(carRepository.getAllCars()).thenReturn(cars);
    }

    @Test
    void testGetExpensiveCars() throws Exception {

        // setup (always on setUp() @BeforeEach)

        String oldCarsJson = objectMapper.writeValueAsString(cars);
        Car[] oldCars = objectMapper.readValue(oldCarsJson, Car[].class);

        // act
        List<Car> expensiveCars = carServiceLocalMemoryImpl.getExpensiveCars(100);

        // assert
        assertEquals(expensiveCars.size(), oldCars.length);
        for (Integer i = 0; i < expensiveCars.size() - 1; i++) {
            assertEquals(oldCars[i].getPrice().multiply(BigDecimal.valueOf(2)),
                    expensiveCars.get(i).getPrice());
        }
    }

    @Test
    void testGetOldCars() throws Exception {
        // setup (always on setUp() @BeforeEach)

        String oldCarsJson = objectMapper.writeValueAsString(cars);
        Car[] oldCars = objectMapper.readValue(oldCarsJson, Car[].class);

        // act
        List<Car> oldCarsService = carServiceLocalMemoryImpl.getOldCars(2);
        // assert
        assertEquals(oldCarsService.size(), oldCars.length);
        for (Integer i = 0; i < oldCarsService.size() - 1; i++) {
            assertEquals(((oldCars[i].getYear()) - 2), oldCarsService.get(i).getYear());
        }
    }

    private List<Car> getAllCars() {
        List<Car> list = new ArrayList<>();

        Car car1 = new Car();
        car1.setMaker("BMW");
        car1.setColor("yellow");
        car1.setModel("x5");
        car1.setYear(2023);
        car1.setCurrency("EUR");
        car1.setPrice(BigDecimal.valueOf(98000));
        list.add(car1);

        Car car2 = new Car();
        car2.setMaker("Mecedes");
        car2.setColor("red");
        car2.setModel("GLE");
        car2.setYear(2020);
        car2.setCurrency("EUR");
        car2.setPrice(BigDecimal.valueOf(124000));
        list.add(car2);

        return list;
    }
}