package ro.raffa.curs.validator;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.experimental.UtilityClass;
import ro.raffa.curs.exception.CarValidatorException;
import ro.raffa.curs.model.Car;

@UtilityClass
public class CarValidator {

    public static Boolean validateCar(Car car) throws CarValidatorException {
        validateCarMaker(car.getMaker());
        validateCarModel(car.getModel());
        validateCarColor(car.getColor());
        validateCarYear(car.getYear());
        validateCarPrice(car.getPrice());
        validateCarCurrency(car.getCurrency());
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
    
    private static void validateCarCurrency(String currency) throws CarValidatorException{
        if(currency == null || currency.isEmpty()) {
            throw new CarValidatorException(9004, currency);
        }
        if(!currency.equals("EUR")){
            throw new CarValidatorException(9005, currency);
        }
    }

    private static void validateCarPrice(BigDecimal price) {
        if(price.equals(BigDecimal.valueOf(0))) {
            throw new CarValidatorException(9006, price.toString());
        }
    }

    private static void validateCarYear(Integer year) {
        if(year > YearMonth.now().getYear()){
            throw new CarValidatorException(9012, year.toString());
        }
        if(year== 0) {
            throw new CarValidatorException(9007, year.toString());
        }
    }

    private static void validateCarModel(String model) {
        if(model == null || model.isEmpty()) {
            throw new CarValidatorException(9008, model);
        }
        if(model.toLowerCase().charAt(0) == model.charAt(0)) {
            throw new CarValidatorException(9009, model);
        }
    }

    private static void validateCarColor(String color) {
        if(color == null || color.isEmpty()) {
            throw new CarValidatorException(9010, color);
        }
        if(color.toLowerCase().charAt(0) == color.charAt(0))  {
            throw new CarValidatorException(9011, color);
        }
    }

}
