package ro.cristi.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ro.cristi.curs.exception.CarValidatorException;
import ro.cristi.curs.model.Car;

@SpringBootTest
class CarValidatorTest {

    private Car goodCar() {
        Car car = new Car();
        car.setMaker("Audi");
        car.setModel("xd");
        car.setYear(2015);
        return car;

    }

    @Test
    public void validateCarMakerNullName() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker(null);
        try {
            CarValidator.validateCarMakerOrModel(car.getMaker(), "maker");
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarMakerEmptyName() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker("");
        try {
            CarValidator.validateCarMakerOrModel(car.getMaker(), "maker");
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarMakerLongName() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker("DaciaBestCarOngFrfrassdsdsad");
        try {
            CarValidator.validateCarMakerOrModel(car.getMaker(), "maker");
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }
    }

    @Test
    public void validateCarMakerLowerCase() throws CarValidatorException {
        Car car = goodCar();
        car.setMaker("dACIA");
        try {
            CarValidator.validateCarMakerOrModel(car.getMaker(), "maker");
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelNullName() throws CarValidatorException {
        Car car = goodCar();
        car.setModel(null);
        try {
            CarValidator.validateCarMakerOrModel(car.getModel(), "model");
        } catch (CarValidatorException e) {
            assertEquals(90004, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelEmptyName() throws CarValidatorException {
        Car car = goodCar();
        car.setModel("");
        try {
            CarValidator.validateCarMakerOrModel(car.getModel(), "model");
        } catch (CarValidatorException e) {
            assertEquals(90004, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelLongName() throws CarValidatorException {
        Car car = goodCar();
        car.setModel("DaciaBestCarOngFrfrassdsdsad");
        try {
            CarValidator.validateCarMakerOrModel(car.getModel(), "model");
        } catch (CarValidatorException e) {
            assertEquals(90005, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelLowerCase() throws CarValidatorException {
        Car car = goodCar();
        car.setModel("dACIA");
        try {
            CarValidator.validateCarMakerOrModel(car.getModel(), "model");
        } catch (CarValidatorException e) {
            assertEquals(90006, e.getErrorCode());
        }
    }

    @Test
    public void validateCarYearNull() throws CarValidatorException{
        Car car = goodCar();
        car.setYear(null);
        try{
            CarValidator.validateCarYear(car.getYear());
        } catch(CarValidatorException e) {
            assertEquals(90007, e.getErrorCode());
        }
    }

    @Test
    public void validateCarYearLow() throws CarValidatorException{
        Car car = goodCar();
        car.setYear(1977);
        try{
            CarValidator.validateCarYear(car.getYear());
        } catch(CarValidatorException e) {
            assertEquals(90008, e.getErrorCode());
        }
    }

    @Test
    public void validateCarYearHigh() throws CarValidatorException{
        Car car = goodCar();
        car.setYear(2024);
        try{
            CarValidator.validateCarYear(car.getYear());
        } catch(CarValidatorException e) {
            assertEquals(90009, e.getErrorCode());
        }
    }

    @Test
    public void validateCarTestGood() throws CarValidatorException {
        Car car = goodCar();
        assertEquals(true, CarValidator.validateCar(car));
    }
}

