package ro.ciprian.curs.validator;

import lombok.experimental.UtilityClass;
import ro.ciprian.curs.exception.CarValidatorException;
import ro.ciprian.curs.model.Car;

@UtilityClass
public class CarValidator {
    

    public static Boolean validateCar(Car car) throws CarValidatorException{
        return validateCarMaker(car.getMaker());
    }

    public static Boolean validateCarMaker(String name) throws CarValidatorException{
        if(name==null || name.isEmpty()) {
            throw new CarValidatorException(90001, "Maker is null");
        }
        if(name.length() > 15) {
            throw new CarValidatorException(90002, "Name is too long");
        }
        if (name.toLowerCase().charAt(0) == name.charAt(0)) {
            throw new CarValidatorException(90003, "First letter is lowercase");
        }
        return true;
    }
}
