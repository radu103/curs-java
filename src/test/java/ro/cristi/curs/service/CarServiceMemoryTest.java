package ro.cristi.curs.service;

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
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.cristi.curs.exception.CarServiceException;
import ro.cristi.curs.model.Car;
import ro.cristi.curs.repository.CarRepository;

@SpringBootTest
@ActiveProfiles("local")
class CarServiceMemoryTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarServiceMemoryImpl carServiceMemoryImpl = new CarServiceMemoryImpl();

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
        List<Car> expensiveCars = carServiceMemoryImpl.getExpensiveCars(100);

        // assert
        assertEquals(expensiveCars.size(), oldCars.length);
        for (Integer i = 0; i < expensiveCars.size() - 1; i++) {
            assertEquals(oldCars[i].getPrice().multiply(BigDecimal.valueOf(2)),
                    expensiveCars.get(i).getPrice());
        }
    }

    @Test
    void testGetExpensiveCars_exceptionNull(){
        when(carRepository.getAllCars()).thenReturn(null);
        try {
            carServiceMemoryImpl.getExpensiveCars(100);
        } catch (CarServiceException e) {
            assertEquals(50001, e.getErrorCode());
        }
    }

    @Test
    void testGetExpensiveCars_exceptionPercent(){
        try{
            carServiceMemoryImpl.getExpensiveCars(150);
        } catch(CarServiceException e) {
            assertEquals(40001, e.getErrorCode());
        }
    }

    @Test
    void testGetExpensiveCars_exceptionSize(){
        when(carRepository.getAllCars()).thenReturn(getTooManyCars());
        try{
            carServiceMemoryImpl.getExpensiveCars(50);
        } catch(CarServiceException e) {
            assertEquals(50002, e.getErrorCode());
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
    private List<Car> getTooManyCars(){
        List<Car> list = new ArrayList<>();
        for(Integer i = 0; i<=1000; i++){
            Car car1 = new Car();
            car1.setMaker("BMW");
            car1.setColor("yellow");
            car1.setModel("x5");
            car1.setYear(2023);
            car1.setCurrency("EUR");
            car1.setPrice(BigDecimal.valueOf(98000));
            list.add(car1);
        }
        return list;
    }
}