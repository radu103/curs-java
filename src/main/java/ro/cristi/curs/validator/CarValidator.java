package ro.cristi.curs.validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;
import ro.cristi.curs.exception.CarValidatorException;
import ro.cristi.curs.model.Car;

@UtilityClass
public class CarValidator {

    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMakerOrModel(car.getMaker(), "maker");
        validateCarMakerOrModel(car.getModel(), "model");
        validateCarYear(car.getYear());
        return true;
    }

    public static void validateCarMakerOrModel(String name, String type) throws CarValidatorException {
        switch(type){
            case "maker":{
        
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
            case "model":{
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
        }
    }

    public static void validateCarYear(Integer year) throws CarValidatorException {
        if(year == null){
            throw new CarValidatorException(90007, "Year is null");
        } else if (year < 1980){
            throw new CarValidatorException(90008, "Year is too low");
        } else if (year > getCurrentYear()) {
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
