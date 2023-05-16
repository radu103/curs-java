package com.andrei.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.andrei.curs.exception.CarValidatorException;
import com.andrei.curs.model.Car;

@SpringBootTest
@ActiveProfiles("local")
public class CarValidatorTest {

    Car createCustomCar(String maker, String model, Integer power,
            String color, Integer year, Integer price, String currency) {

        Car car = new Car();
        car.setMaker(maker);
        car.setModel(model);
        car.setPower(power);
        car.setColor(color);
        car.setYear(year);
        car.setPrice(BigDecimal.valueOf(price));
        car.setCurrency(currency);

        return car;
    }

    @Test
    void testValidateCarMakerNull() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, null);
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarMakerTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar("makeeeeeeeeeeeeer", null, null, null, null, 0, null);
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarMakerUpperCase() throws CarValidatorException {

        try {
            Car car = createCustomCar("maker", null, null, null, null, 0, null);
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarModelNull() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, null);
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarModelTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, "modeeeeeeeeeeeeel", null, null, null, 0, null);
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarModelUpperCase() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, "model", null, null, null, 0, null);
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarPower() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, null);
            CarValidator.validateCarPower(car.getPower());
        } catch (CarValidatorException e) {
            assertEquals(70001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarColorNull() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, null);
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(60001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarColorTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, "colooooooooooooor", null, 0, null);
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(60002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarColorLowerCase() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, "Color", null, 0, null);
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(60003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarYearNull() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, null);
            CarValidator.validateCarYear(car.getYear());
        } catch (CarValidatorException e) {
            assertEquals(50001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarYearOld() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, 2018, 0, null);
            CarValidator.validateCarYear(car.getYear());
        } catch (CarValidatorException e) {
            assertEquals(50002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarPriceNull() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, null);
            CarValidator.validateCarPrice(car.getPrice());
        } catch (CarValidatorException e) {
            assertEquals(40001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarCurrencyNull() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, null);
            CarValidator.validateCarCurrency(car.getCurrency());
        } catch (CarValidatorException e) {
            assertEquals(30001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarCurrencyTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, "curreeeeeeeeeeeey");
            CarValidator.validateCarCurrency(car.getCurrency());
        } catch (CarValidatorException e) {
            assertEquals(30002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarCurrencyUpperCase() throws CarValidatorException {

        try {
            Car car = createCustomCar(null, null, null, null, null, 0, "eur");
            CarValidator.validateCarCurrency(car.getCurrency());
        } catch (CarValidatorException e) {
            assertEquals(30003, e.getErrorCode());
        }
    }
}