package ro.andu.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ro.andu.curs.exception.CarValidatorException;
import ro.andu.curs.model.Car;

@SpringBootTest
public class CarValidatorTest {

    @Test
    void testValidateCars_exception(){
        Car car = new Car();
        car.setMaker(null);
        try {
            CarValidator.validateCar(car);;
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsLenght_exception() {
        Car car = new Car();
        car.setMaker("aaaaaaaaaaaaaaaa");
        try {
            CarValidator.validateCar(car);;
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsUppercase_exception(){
        Car car = new Car();
        car.setMaker("name");
        try {
            CarValidator.validateCar(car);;
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsIsOk_exception(){
        Car car = new Car();
        car.setMaker("Ford");
        assertTrue(CarValidator.validateCar(car));
    }
}
