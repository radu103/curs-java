package ro.andu.curs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.andu.curs.exception.CarServiceException;
import ro.andu.curs.model.Car;
import ro.andu.curs.repository.CarRepository;

@SpringBootTest
public class CarServiceMemoryTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarServiceMemoryImpl carService = new CarServiceMemoryImpl();

    @Autowired
    ObjectMapper objectMapper;

    List<Car> cars;

    @BeforeEach
    void setUp() {
        // setup
        cars = getAllCars();
        when(carRepository.getAllCars()).thenReturn(cars);
    }

    @Test
    void testGetExpensiveCars() throws Exception {
        // setup (always on setUp() @BeforeEach)
        String oldCarJson = objectMapper.writeValueAsString(cars);
        Car[] oldCars = objectMapper.readValue(oldCarJson, Car[].class);

        // act
        List<Car> expensiveCars = carService.getExpensiveCars(100);

        // assert
        assertEquals(expensiveCars.size(), oldCars.length);

        for (Integer i = 0; i < expensiveCars.size() - 1; i++) {
            assertEquals(oldCars[i].getPrice().multiply(BigDecimal.valueOf(2)), expensiveCars.get(i).getPrice());
        }
    }

    @Test
    void testGetOlderCars() throws Exception {
        String oldCarJson = objectMapper.writeValueAsString(cars);
        Car[] oldCar = objectMapper.readValue(oldCarJson, Car[].class);

        Integer years = 2;

        List<Car> olderCars = carService.getOlderCars(years);

        assertEquals(olderCars.size(), oldCar.length);

        for (Integer i = 0; i < olderCars.size() - 1; i++) {
            assertEquals(oldCar[i].getYear() - years, olderCars.get(i).getYear());
        }
    }

    @Test
    void testGetExpensiveCars_exception(){
        when(carRepository.getAllCars()).thenReturn(null);
        try {
            carService.getExpensiveCars(100);
        } catch (CarServiceException e) {
            assertEquals(500, e.getErrorCode());
        }
    }

    @Test
    void testGetExpensiveCars_exception_percent(){
        when(carRepository.getAllCars()).thenReturn(null);
        try {
            carService.getExpensiveCars(101);
        } catch (CarServiceException e) {
            assertEquals(400, e.getErrorCode());
        }
    }
    @Test
    void testGetExpensiveCars_exception_maxCars() {
        for (int i=0; i<=1001;i++) {
            carService.addCars("a", "b", "c", 1, 2);
        }
        try {
            carService.getExpensiveCars(100);
        } catch (CarServiceException e) {
            assertEquals(300, e.getErrorCode());
        }
    }

    @Test
    void testGetExpensiveCars_exception_validated() {
        carService.addCars("a", "b", "c", 1, 2);
        try {
            carService.getExpensiveCars(100);
        } catch (CarServiceException e) {
            assertEquals(90001, e.getErrorCode());
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

        return list;
    }

}
