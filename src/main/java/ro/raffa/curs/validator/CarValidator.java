package ro.raffa.curs.validator;

import lombok.experimental.UtilityClass;
import ro.raffa.curs.exception.CarValidatorException;
import ro.raffa.curs.model.Car;

@UtilityClass
public class CarValidator {
    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMaker(car.getMaker());
        return true;
    }

    private static void validateCarMaker(String name) throws CarValidatorException {
        if (name == null || name.isEmpty()) {
            throw new CarValidatorException(90001, name);
        }
        if (name.length() > 15) {
            throw new CarValidatorException(90002, name);
        }
        if (name.toLowerCase().charAt(0) == name.charAt(0)) {
            throw new CarValidatorException(90003, name);
        }
    }

}
