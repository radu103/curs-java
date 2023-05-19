package ro.ciprian.curs.service;

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

import ro.ciprian.curs.exception.CarServiceException;
import ro.ciprian.curs.model.Car;
import ro.ciprian.curs.repository.CarRepository;

@SpringBootTest
public class CarServiceMemoryTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarServiceMemoryImpl carServiceMemoryImpl = new CarServiceMemoryImpl();

    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

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
    void testGetExpensiveCars_exception(){
        when(carRepository.getAllCars()).thenReturn(null);
        try{
            carServiceMemoryImpl.getExpensiveCars(100);
        } catch (CarServiceException e) {
            assertEquals(500, e.getErrorCode());
        }
    }

    @Test
    void testGetExpensiveCars_exception_percentage(){
        try{
            carServiceMemoryImpl.getExpensiveCars(101);
        } catch (CarServiceException e) {
            assertEquals(400, e.getErrorCode());
        }
    }

    @Test
    void testGetExpensiveCare_exception_size(){
        when(carRepository.getAllCars()).thenReturn(get1001Cars());
        try{
            carServiceMemoryImpl.getExpensiveCars(100);
        } catch (CarServiceException e) {
            assertEquals(600, e.getErrorCode());
        }
    }

    @Test
    void getCheaperCars() throws Exception {
        // setup
        String oldCarsJson = objectMapper.writeValueAsString(cars);
        Car[] oldCars = objectMapper.readValue(oldCarsJson, Car[].class);

        // act
        List<Car> cheapCars = carServiceMemoryImpl.getCheaperCars(100);

        // assert
        assertEquals(oldCars.length, cheapCars.size());

        for (Integer i = 0; i < cheapCars.size() - 1; i++) {
            assertEquals(oldCars[i].getPrice().divide(BigDecimal.valueOf(2)),
                    cheapCars.get(i).getPrice());
        }
    }

    private List<Car> get1001Cars(){
        List<Car> list = new ArrayList<>();
        for(int i=1;i<=1001;i++) {
            Car car1 = new Car();
            car1.setMaker("BMW");
            car1.setColor("yellow");
            car1.setModel("x5");
            car1.setYear(2023);
            car1.setCurrency("EUR");
            car1.setPrice(BigDecimal.valueOf(90000));
            list.add(car1);
        }
        return list;
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
