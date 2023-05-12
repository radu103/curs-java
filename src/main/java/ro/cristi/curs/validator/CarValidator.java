package ro.cristi.curs.validator;

import lombok.experimental.UtilityClass;
import ro.cristi.curs.exception.CarValidatorException;
import ro.cristi.curs.model.Car;

@UtilityClass
public class CarValidator {

    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMaker(car.getMaker());
        return true;
    }

    public static void validateCarMaker(String name) throws CarValidatorException {
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
}
