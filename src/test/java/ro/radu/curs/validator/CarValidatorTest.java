package ro.radu.curs.validator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ro.radu.curs.model.Car;

@SpringBootTest
@ActiveProfiles("local")
class CarValidatorTest {

    @Test
    void validateCar_ok() {
        Car car = new Car();
        car.setMaker("Audi");
        assertTrue(CarValidator.validateCar(car));
    }
}
