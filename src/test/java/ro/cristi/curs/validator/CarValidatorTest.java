package ro.cristi.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ro.cristi.curs.exception.CarValidatorException;
import ro.cristi.curs.model.Car;

@SpringBootTest
class CarValidatorTest {

    private Car goodCar() {
        Car car = new Car();
        car.setMaker("Audi");
        return car;

    }

    @Test
    public void validateCarMakerNullName() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker(null);
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }

    }

    @Test
    public void validateCarMakerEmptyName() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker("");
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }

    }

    @Test
    public void validateCarMakerLongName() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker("DaciaBestCarOngFrfrassdsdsad");
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }

    }

    @Test
    public void validateCarMakerLowerCase() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker("dACIA");
        try {
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }

    }

    @Test
    public void validateCarTestGood() {
        Car car = goodCar();
        assertEquals(CarValidator.validateCarMaker(car.getMaker()), true);
    }

}
