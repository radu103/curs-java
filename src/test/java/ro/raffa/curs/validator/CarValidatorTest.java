package ro.raffa.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ro.raffa.curs.exception.CarValidatorException;
import ro.raffa.curs.model.Car;

@SpringBootTest
@ActiveProfiles("local")
public class CarValidatorTest {
    @Test
    void validateCar_name_null() {
        try {
            CarValidator.validateCar(createCar(null));
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_empty() {
        try {
            CarValidator.validateCar(createCar(""));
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_over_15() {
        try {
            CarValidator.validateCar(createCar("Kiewjiejfiejefwefwewef"));
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_firstChar_lowerCase() {
        try {
            CarValidator.validateCar(createCar("mercedes"));
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_okay() {
        Boolean result = CarValidator.validateCar(createCar("Mercedes"));
        assertTrue(result);
    }

    Car createCar(String maker) {
        Car car = new Car();
        car.setMaker(maker);
        car.setColor("yellow");
        car.setModel("x5");
        car.setYear(2023);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(98000));
        return car;
    }
}