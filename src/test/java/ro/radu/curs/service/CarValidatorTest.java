package ro.radu.curs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ro.radu.curs.exception.CarValidatorException;
import ro.radu.curs.model.Car;
import ro.radu.curs.validator.CarValidator;

@SpringBootTest
public class CarValidatorTest {

    private Car corectCar() {
        Car car = new Car();
        car.setMaker("Nissan");
        return car;
    }

    @Test
    public void validateCarNameNull() {
        Car car = corectCar();
        car.setMaker(null);
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarNameLength() {
        Car car = corectCar();
        car.setMaker("Nissannnnaa");
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }
    }

    @Test
    public void validateCarNameLowerCase() {
        Car car = corectCar();
        car.setMaker("nissan");
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }
    }

    @Test
    public void validateCarNameEmpty() {
        Car car = corectCar();
        car.setMaker("");
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarNameOk() {
        Car car = corectCar();
        assertEquals(CarValidator.validateCarMaker(car.getMaker()),true);
    }

}
