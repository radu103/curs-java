package ro.andu.curs.validator;

import lombok.experimental.UtilityClass;
import ro.andu.curs.exception.CarValidatorException;
import ro.andu.curs.model.Car;

@UtilityClass
public class CarValidator {
    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMaker(car.getMaker());
        return true;
    }

    public static void validateCarMaker(String name) throws CarValidatorException {
        if (name == null || name.isEmpty()) {
            throw new CarValidatorException(90001, "Maker name is null");
        }
        if (name.length() > 15) {
            throw new CarValidatorException(90002, "Maker name must be smaller then 15 letters");
        }
        if (name.toLowerCase().charAt(0) == (name.charAt(0))) {
            throw new CarValidatorException(90003, "Maker name first letter must be upper case");
        }
    }
}
