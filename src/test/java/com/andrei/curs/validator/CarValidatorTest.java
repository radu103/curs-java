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

    Car createCustomCar(String fieldName, String fieldValueString, Integer fieldValueInteger) {
        Car car = new Car();
        if (fieldName == "maker") {
            car.setMaker(fieldValueString);
            car.setModel("Model");
            car.setPower(200);
            car.setColor("alb");
            car.setYear(2023);
            car.setPrice(BigDecimal.valueOf(100000));
            car.setCurrency("EUR");
        } else if (fieldName == "model") {
            car.setModel(fieldValueString);
            car.setMaker("Maker");
            car.setPower(200);
            car.setColor("alb");
            car.setYear(2023);
            car.setPrice(BigDecimal.valueOf(100000));
            car.setCurrency("EUR");
        } else if (fieldName == "power") {
            car.setPower(fieldValueInteger);
            car.setMaker("Maker");
            car.setModel("Model");
            car.setColor("alb");
            car.setYear(2023);
            car.setPrice(BigDecimal.valueOf(100000));
            car.setCurrency("EUR");
        } else if (fieldName == "color") {
            car.setColor(fieldValueString);
            car.setMaker("Maker");
            car.setModel("Model");
            car.setPower(200);
            car.setYear(2023);
            car.setPrice(BigDecimal.valueOf(100000));
            car.setCurrency("EUR");
        } else if (fieldName == "year") {
            car.setYear(fieldValueInteger);
            car.setMaker("Maker");
            car.setModel("Model");
            car.setPower(200);
            car.setColor("alb");
            car.setPrice(BigDecimal.valueOf(100000));
            car.setCurrency("EUR");
        } else if (fieldName == "price") {
            car.setPrice(BigDecimal.valueOf(fieldValueInteger));
            car.setMaker("Maker");
            car.setModel("Model");
            car.setPower(200);
            car.setColor("alb");
            car.setYear(2023);
            car.setPrice(BigDecimal.valueOf(100000));
            car.setCurrency("EUR");
        } else if (fieldName == "currency") {
            car.setCurrency(fieldValueString);
            car.setMaker("Maker");
            car.setModel("Model");
            car.setPower(200);
            car.setColor("alb");
            car.setYear(2023);
            car.setPrice(BigDecimal.valueOf(100000));
        }

        return car;
    }

    @Test
    void testValidateCarMakerNull() throws CarValidatorException {

        try {
            Car car = createCustomCar("maker", null, null);
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarMakerTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar("maker", "makeeeeeeeeeeeeer", null);
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarMakerUpperCase() throws CarValidatorException {

        try {
            Car car = createCustomCar("maker", "maker", null);
            CarValidator.validateCarMaker(car.getMaker());
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarModelNull() throws CarValidatorException {

        try {
            Car car = createCustomCar("model", null, null);
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarModelTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar("model", "modeeeeeeeeeeeeel", null);
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarModelUpperCase() throws CarValidatorException {

        try {
            Car car = createCustomCar("model", "model", null);
            CarValidator.validateCarModel(car.getModel());
        } catch (CarValidatorException e) {
            assertEquals(80003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarPower() throws CarValidatorException {

        try {
            Car car = createCustomCar("power", null, null);
            CarValidator.validateCarPower(car.getPower());
        } catch (CarValidatorException e) {
            assertEquals(70001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarColorNull() throws CarValidatorException {

        try {
            Car car = createCustomCar("color", null, null);
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(60001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarColorTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar("color", "colooooooooooooor", null);
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(60002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarColorLowerCase() throws CarValidatorException {

        try {
            Car car = createCustomCar("color", "Color", null);
            CarValidator.validateCarColor(car.getColor());
        } catch (CarValidatorException e) {
            assertEquals(60003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarYearNull() throws CarValidatorException {

        try {
            Car car = createCustomCar("year", null, null);
            CarValidator.validateCarYear(car.getYear());
        } catch (CarValidatorException e) {
            assertEquals(50001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarYearOld() throws CarValidatorException {

        try {
            Car car = createCustomCar("year", null, 2018);
            CarValidator.validateCarYear(car.getYear());
        } catch (CarValidatorException e) {
            assertEquals(50002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarPriceNull() throws CarValidatorException {

        try {
            Car car = createCustomCar("price", null, 0);
            CarValidator.validateCarPrice(car.getPrice());
        } catch (CarValidatorException e) {
            assertEquals(40001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarCurrencyNull() throws CarValidatorException {

        try {
            Car car = createCustomCar("currency", null, null);
            CarValidator.validateCarCurrency(car.getCurrency());
        } catch (CarValidatorException e) {
            assertEquals(30001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarCurrencyTooLong() throws CarValidatorException {

        try {
            Car car = createCustomCar("currency", "currenccccccccccy", null);
            CarValidator.validateCarCurrency(car.getCurrency());
        } catch (CarValidatorException e) {
            assertEquals(30002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarCurrencyUpperCase() throws CarValidatorException {

        try {
            Car car = createCustomCar("currency", "eur", null);
            CarValidator.validateCarCurrency(car.getCurrency());
        } catch (CarValidatorException e) {
            assertEquals(30003, e.getErrorCode());
        }
    }
}