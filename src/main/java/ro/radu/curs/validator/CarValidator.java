package ro.radu.curs.validator;

import java.math.BigDecimal;

import lombok.experimental.UtilityClass;
import ro.radu.curs.exception.CarValidatorException;
import ro.radu.curs.model.Car;

@UtilityClass
public class CarValidator {

    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMaker(car.getMaker());
        validateCarModel(car.getModel());
        validateCarColor(car.getColor());
        validateCarYear(car.getYear());
        validateCarPrice(car.getPrice());
        validateCarHp(car.getHp());

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

    public static Boolean validateCarColor(String color) throws CarValidatorException {
        if (color == null || color.isEmpty()) {
            throw new CarValidatorException(70001, "Color is null or empty");
        }
        if (color.length() > 15) {
            throw new CarValidatorException(70002, "Color is too long");
        }
        if (color.toLowerCase().charAt(0) == color.charAt(0)) {
            throw new CarValidatorException(70003, "Color must start with uppercase");
        }
        return true;
    }

    public static Boolean validateCarYear(Integer year) throws CarValidatorException {
        if (year == null || year == 0) {
            throw new CarValidatorException(60001, "Year is null or empty");
        }
        return true;
    }

    public static Boolean validateCarPrice(BigDecimal price) throws CarValidatorException {
        if (price == null || price.equals(0)) {
            throw new CarValidatorException(50001, "Price is null or empty");
        }
        return true;
    }

    public static Boolean validateCarHp(Integer hp) throws CarValidatorException {
        if (hp == null || hp == 0) {
            throw new CarValidatorException(40001, "Hp is null or empty");
        }
        return true;
    }
}