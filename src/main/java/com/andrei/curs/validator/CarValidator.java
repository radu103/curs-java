package com.andrei.curs.validator;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

import com.andrei.curs.exception.CarValidatorException;
import com.andrei.curs.model.Car;

@UtilityClass
public class CarValidator {

    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMaker(car.getMaker());
        validateCarModel(car.getModel());
        validateCarPower(car.getPower());
        validateCarColor(car.getColor());
        validateCarYear(car.getYear());
        validateCarPrice(car.getPrice());
        validateCarCurrency(car.getCurrency());

        return true;
    }

    public static Boolean validateCarMaker(String name) throws CarValidatorException {
        if (name == null || name.isEmpty()) {
            throw new CarValidatorException(90001, "Maker is null or empty");
        }
        if (name.length() > 15) {
            throw new CarValidatorException(90002, "Maker is too long");
        }
        if (name.toLowerCase().charAt(0) == name.charAt(0)) {
            throw new CarValidatorException(90003, "Maker must start with uppercase");
        }
        return true;
    }

    public static Boolean validateCarModel(String model) throws CarValidatorException {
        if (model == null || model.isEmpty()) {
            throw new CarValidatorException(80001, "Model is null or empty");
        }
        if (model.length() > 15) {
            throw new CarValidatorException(80002, "Model is too long");
        }
        if (model.toLowerCase().charAt(0) == model.charAt(0)) {
            throw new CarValidatorException(80003, "Model must start with uppercase");
        }
        return true;
    }

    public static Boolean validateCarPower(Integer power) throws CarValidatorException {
        if (power == null || power == 0) {
            throw new CarValidatorException(70001, "Power is null or empty");
        }
        return true;
    }

    public static Boolean validateCarColor(String color) throws CarValidatorException {
        if (color == null || color.isEmpty()) {
            throw new CarValidatorException(60001, "Color is null or empty");
        }
        if (color.length() > 15) {
            throw new CarValidatorException(60002, "Color is too long");
        }
        if (color.toUpperCase().charAt(0) == color.charAt(0)) {
            throw new CarValidatorException(60003, "Color must start with lowercase");
        }
        return true;
    }

    public static Boolean validateCarYear(Integer year) throws CarValidatorException {
        if (year == null || year == 0) {
            throw new CarValidatorException(50001, "Year is null or empty");
        }
        if (year < 2019) {
            throw new CarValidatorException(50002, "Year is lower than 2019");
        }
        return true;
    }

    public static Boolean validateCarPrice(BigDecimal price) throws CarValidatorException {
        if (price == null || price.equals(0)) {
            throw new CarValidatorException(40001, "Price is null or empty");
        }
        return true;
    }

    public static Boolean validateCarCurrency(String currency) throws CarValidatorException {
        if (currency == null || currency.isEmpty()) {
            throw new CarValidatorException(30001, "Currency is null or empty");
        }
        if (currency.length() > 15) {
            throw new CarValidatorException(30002, "Currency is too long");
        }
        if (currency.toLowerCase() == currency) {
            throw new CarValidatorException(30003, "Currency must be written with uppercase letters");
        }
        return true;
    }
}