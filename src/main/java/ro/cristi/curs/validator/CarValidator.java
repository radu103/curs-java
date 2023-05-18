package ro.cristi.curs.validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;
import ro.cristi.curs.exception.CarValidatorException;
import ro.cristi.curs.model.Car;

@UtilityClass
public class CarValidator {

    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMaker(car.getMaker());
        validateCarModel(car.getModel());
        validateCarYear(car.getYear());
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
    }
    

    public static void validateCarModel(String name) throws CarValidatorException {
        if (name == null || name.isEmpty()) {
            throw new CarValidatorException(90004, "Model is null or empty");
        }
        if (name.length() > 15) {
           throw new CarValidatorException(90005, "Model is too long");
        }
        if (name.toLowerCase().charAt(0) == name.charAt(0)) {
            throw new CarValidatorException(90006, "Model must start with uppercase");
        }
    }

    public static void validateCarYear(Integer year) throws CarValidatorException {
        if(year == null){
            throw new CarValidatorException(90007, "Year is null");
        }
        if (year < 1980){
            throw new CarValidatorException(90008, "Year is too low");
        }
        if (year > getCurrentYear()) {
            throw new CarValidatorException(90009, "Year is too high");
        }
    }

    public Integer getCurrentYear(){
        DateTimeFormatter timp = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
        Integer currentYear = Integer.parseInt(timp.format(now));
        return currentYear;
    }
}
