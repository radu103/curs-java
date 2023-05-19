package ro.ciprian.curs.validator;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.experimental.UtilityClass;
import ro.ciprian.curs.exception.CarValidatorException;
import ro.ciprian.curs.model.Car;

@UtilityClass
public class CarValidator {
    

    public static Boolean validateCar(Car car) throws CarValidatorException{
        if(validateCarMaker(car.getMaker())==true
            && validateCarModel(car.getModel())==true
            && validateCarColor(car.getColor())==true
            && validateCarYear(car.getYear())==true
            && validateCarPrice(car.getPrice())==true
            && validateCarMileage(car.getMileage())==true
            && validateCarCurrency(car.getCurrency())==true) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean validateCarMaker(String name) throws CarValidatorException{
        if(name==null || name.isEmpty()) {
            throw new CarValidatorException(90001, "Maker is null");
        }
        if(name.length() > 15) {
            throw new CarValidatorException(90002, "Maker name is too long");
        }
        if (name.toLowerCase().charAt(0) == name.charAt(0)) {
            throw new CarValidatorException(90003, "First letter is lowercase");
        }
        return true;
    }

    public static Boolean validateCarModel(String model) throws CarValidatorException{
        if(model==null || model.isEmpty()) {
            throw new CarValidatorException(90011, "Model is null");
        }
        if(model.length() > 15) {
            throw new CarValidatorException(90012, "Model name is too long");
        }
        if (model.toLowerCase().charAt(0) == model.charAt(0)) {
            throw new CarValidatorException(90013, "First letter is lowercase");
        }
        return true;
    }

    public static Boolean validateCarColor(String color) throws CarValidatorException{
        if(color==null || color.isEmpty()) {
            throw new CarValidatorException(90021, "Color is null");
        }
        if(color.length() > 15) {
            throw new CarValidatorException(90022, "Color name is too long");
        }
        if (color.toLowerCase().charAt(0) == color.charAt(0)) {
            throw new CarValidatorException(90023, "First letter is lowercase");
        }
        return true;
    }

    public static Boolean validateCarYear(Integer year) throws CarValidatorException{
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if(year==null) {
            throw new CarValidatorException(90031, "Year is null");
        }
        if(year < currentYear-100) {
            throw new CarValidatorException(90032, "The car is too old");
        }
        if(year > currentYear+1) {
            throw new CarValidatorException(90033, "The car has not launched yet.");
        }
        return true;
    }

    public static Boolean validateCarPrice(BigDecimal price) throws CarValidatorException{
        var minimv = BigDecimal.valueOf(5000);
        var maximv = BigDecimal.valueOf(500000);

        if(price==null) {
            throw new CarValidatorException(90041, "Price is null");
        }
        if(price.compareTo(minimv) < 0) {
            throw new CarValidatorException(90042, "The price is too small(minimum 5000)");
        }
        if(price.compareTo(maximv) > 0) {
            throw new CarValidatorException(90043, "The price is too high(maximum 500,000).");
        }
        return true;
    }

    public static Boolean validateCarMileage(Integer mileage) throws CarValidatorException{
        if(mileage==null) {
            throw new CarValidatorException(90051, "Mileage is null");
        }
        if(mileage > 500) {
            throw new CarValidatorException(90052, "The mileage is too high(maximum 500 miles)");
        }
        return true;
    }

    public static Boolean validateCarCurrency(String currency) throws CarValidatorException{
        if(currency==null || currency.isEmpty()) {
            throw new CarValidatorException(90061, "Mileage is null");
        }
        if(!(currency.equals("EUR") || currency.equals("USD") || currency.equals("RON"))) {
            throw new CarValidatorException(90062, "The currency is invalid");
        }
        return true;
    }
}
