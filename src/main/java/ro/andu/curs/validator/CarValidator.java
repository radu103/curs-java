package ro.andu.curs.validator;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.experimental.UtilityClass;
import ro.andu.curs.exception.CarValidatorException;
import ro.andu.curs.model.Car;

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
    public static void validateCarModel(String model) throws CarValidatorException {
        if (model == null || model.isEmpty()) {
            throw new CarValidatorException(90011, "Model name is null");
        }
        if (model.length() > 15) {
            throw new CarValidatorException(90012, "Model name must be smaller then 15 letters");
        }
        if (model.toLowerCase().charAt(0) == (model.charAt(0))) {
            throw new CarValidatorException(90013, "Model name first letter must be upper case");
        }
    }
    public static void validateCarColor(String color) throws CarValidatorException {
        if (color == null || color.isEmpty()) {
            throw new CarValidatorException(90021, "Color is null");
        }
        if (color.length() > 15) {
            throw new CarValidatorException(90022, "Color size must be smaller then 15 letters");
        }
        if (color.toLowerCase().charAt(0) == (color.charAt(0))) {
            throw new CarValidatorException(90023, "Color first letter must be upper case");
        }
    }
    public static void validateCarYear(int year) throws CarValidatorException {
        int cYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year==0) {
            throw new CarValidatorException(90031, "Year is null");
        }
        if (year < 1886) {
            throw new CarValidatorException(90032, "Year must be bigger then 1886");
        }
        if (year > cYear+1) {
            throw new CarValidatorException(90033, "Year is too big. Max: " + cYear + 1);
        }
    }
    public static void validateCarPrice(BigDecimal price) throws CarValidatorException {
        if (price.compareTo(new BigDecimal(0))==0) {
            throw new CarValidatorException(90041, "Price is null");
        }
        if (price.compareTo(new BigDecimal(100))<0) {
            throw new CarValidatorException(90042, "Car can't be this cheap");
        }
    }
    public static void validateCarCurrency(String currency) throws CarValidatorException {
        if (currency == null || currency.isEmpty()) {
            throw new CarValidatorException(90051, "Currency is null");
        }
        if (!(currency.equals("EUR")|| currency.equals("USD"))) {
            throw new CarValidatorException(90052, "Currency must be either EUR or USD");
        }
    }
}
