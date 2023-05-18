package ro.radu.curs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

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
        car.setColor("Blue");
        car.setModel("Gtr");
        car.setYear(2002);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(69000));
        car.setHp(276);
        return car;
    }

    //..................................................................................

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

    //....................................................................................

    @Test
    public void validateCarModelNull() {
        Car car = corectCar();
        car.setModel(null);
        try {
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelLength() {
        Car car = corectCar();
        car.setModel("Gtrrrrrrrrrrrrrrrrrrrrrr");
        try {
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80002, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelLowerCase() {
        Car car = corectCar();
        car.setModel("gtr");
        try {
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80003, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelEmpty() {
        Car car = corectCar();
        car.setModel("");
        try {
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarModelOk() {
        Car car = corectCar();
        assertEquals(CarValidator.validateCarModel(car.getModel()),true);
    }

    //...................................................................................

    @Test
    public void validateCarColorNull() {
        Car car = corectCar();
        car.setColor(null);
        try {
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(70001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarColorLength() {
        Car car = corectCar();
        car.setColor("Blueeeeeeeeeeeeeeeeeeee");
        try {
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(70002, e.getErrorCode());
        }
    }

    @Test
    public void validateCarColorLowerCase() {
        Car car = corectCar();
        car.setColor("blue");
        try {
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(70003, e.getErrorCode());
        }
    }

    @Test
    public void validateCarColorEmpty() {
        Car car = corectCar();
        car.setColor("");
        try {
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(70001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarColorOk() {
        Car car = corectCar();
        assertEquals(CarValidator.validateCarColor(car.getColor()),true);
    }

    //...................................................................................

    @Test
    public void validateCarYearNull() {
        Car car = corectCar();
        car.setYear(null);
        try {
            CarValidator.validateCarYear(car.getYear());
        } catch (CarValidatorException e) {
            assertEquals(60001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarYearEmpty() {
        Car car = corectCar();
        car.setYear(0);
        try {
            CarValidator.validateCarYear(car.getYear());
        } catch (CarValidatorException e) {
            assertEquals(60001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarYearOk() {
        Car car = corectCar();
        assertEquals(CarValidator.validateCarYear(car.getYear()),true);
    }

    //....................................................................................

    @Test
    public void validateCarHpNull() {
        Car car = corectCar();
        car.setHp(null);
        try {
            CarValidator.validateCarHp(car.getHp());
        } catch (CarValidatorException e) {
            assertEquals(40001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarHpEmpty() {
        Car car = corectCar();
        car.setHp(0);
        try {
            CarValidator.validateCarHp(car.getHp());
        } catch (CarValidatorException e) {
            assertEquals(40001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarHpOk() {
        Car car = corectCar();
        assertEquals(CarValidator.validateCarHp(car.getHp()),true);
    }

    //.................................................................................

    @Test
    public void validateCarPriceNull() {
        Car car = corectCar();
        car.setPrice(null);
        try {
            CarValidator.validateCarPrice(car.getPrice());
        } catch (CarValidatorException e) {
            assertEquals(50001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarPriceEmpty() {
        Car car = corectCar();
        car.setPrice(BigDecimal.valueOf(0));
        try {
            CarValidator.validateCarPrice(car.getPrice());
        } catch (CarValidatorException e) {
            assertEquals(50001, e.getErrorCode());
        }
    }

    @Test
    public void validateCarPriceOk() {
        Car car = corectCar();
        assertEquals(CarValidator.validateCarPrice(car.getPrice()),true);
    }

}
