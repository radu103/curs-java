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
    void testValidateCarMaker() throws CarValidatorException {

        try {
            Car car = createCustomCar("maker", null, null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("maker", "makeeeeeeeeeeeeer", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("maker", "maker", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarModel() throws CarValidatorException {

        try {
            Car car = createCustomCar("model", null, null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(80001, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("model", "modeeeeeeeeeeeeel", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(80002, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("model", "model", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(80003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarPower() throws CarValidatorException {

        try {
            Car car = createCustomCar("power", null, null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(70001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarColor() throws CarValidatorException {

        try {
            Car car = createCustomCar("color", null, null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(60001, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("color", "colooooooooooooor", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(60002, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("color", "Color", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(60003, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarYear() throws CarValidatorException {

        try {
            Car car = createCustomCar("year", null, null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(50001, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("year", null, 2018);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(50002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarPrice() throws CarValidatorException {

        try {
            Car car = createCustomCar("price", null, 0);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(40001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarCurrency() throws CarValidatorException {

        try {
            Car car = createCustomCar("currency", null, null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(30001, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("currency", "currenccccccccccy", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(30002, e.getErrorCode());
        }

        try {
            Car car = createCustomCar("currency", "eur", null);
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(30003, e.getErrorCode());
        }
    }
}