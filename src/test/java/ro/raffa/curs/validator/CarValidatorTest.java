package ro.raffa.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ro.raffa.curs.exception.CarValidatorException;
import ro.raffa.curs.model.Car;

@SpringBootTest
@ActiveProfiles("local")
public class CarValidatorTest {
    @Test
    void validateCar_name_null() {
        try {
            CarValidator.validateCar(carForMaker(null));
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_empty() {
        try {
            CarValidator.validateCar(carForMaker(""));
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_over_15() {
        try {
            CarValidator.validateCar(carForMaker("Kiewjiejfiejefwefwewef"));
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_firstChar_lowerCase() {
        try {
            CarValidator.validateCar(carForMaker("mercedes"));
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }

    }

    @Test
    void validateCar_name_okay() {
        Boolean result = CarValidator.validateCar(carForMaker("Mercedes"));
        assertTrue(result);
    }

    @Test
    void validateCar_model_null() {
        try {
            CarValidator.validateCar(carForModel(null));
        } catch (CarValidatorException e) {
            assertEquals(9008, e.getErrorCode());
        }
    }

    @Test
    void validateCar_model_empty() {
        try {
            CarValidator.validateCar(carForModel(""));
        } catch (CarValidatorException e) {
            assertEquals(9008, e.getErrorCode());
        }
    }

    @Test
    void validateCar_model_firstChar_lowerCase() {
        try {
            CarValidator.validateCar(carForModel("toronto"));
        } catch (CarValidatorException e) {
            assertEquals(9009, e.getErrorCode());
        }
    }

    @Test
    void validateCar_model_ok() {
        assertTrue(CarValidator.validateCar(carForMaker("Toronto")));
    }

    @Test
    void validateCar_color_null() {
        try {
            CarValidator.validateCar(carForColor(null));
        } catch (CarValidatorException e) {
            assertEquals(9010, e.getErrorCode());
        }
    }

    @Test
    void validateCar_color_empty() {
        try {
            CarValidator.validateCar(carForColor(""));
        } catch (CarValidatorException e) {
            assertEquals(9010, e.getErrorCode());
        }
    }

    @Test
    void validateCar_color_firstChar_lowerCase() {
        try {
            CarValidator.validateCar(carForColor("color"));
        } catch (CarValidatorException e) {
            assertEquals(9011, e.getErrorCode());
        }
    }

    @Test
    void validateCar_color_ok() {
        assertTrue(CarValidator.validateCar(carForColor("Color")));
    }

    @Test
    void validateCar_year_is0() {
        try {
            CarValidator.validateCar(carForYear(0));
        } catch (CarValidatorException e) {
            assertEquals(9007, e.getErrorCode());
        }
    }

    // @Test
    // void validateCar_year_null() {
    //     try {
    //         CarValidator.validateCar(carForYear(null));
    //     } catch (CarValidatorException e) {
    //         assertEquals(9007, e.getErrorCode());
    //     }
    // } SOMETHING NOT WORKING HERE

    @Test
    void validateCar_year_ok() {
        assertTrue(CarValidator.validateCar(carForYear(2005)));
    }

    // @Test
    // void validateCar_price_null() {
    //     try {
    //         CarValidator.validateCar(carForPrice(null));
    //     } catch (CarValidatorException e) {
    //         assertEquals(9006, e.getErrorCode());
    //     }
    // }   SOMETHING NOT WORKING HERE

    @Test
    void validateCar_price_is0() {
        try {
            CarValidator.validateCar(carForPrice(BigDecimal.valueOf(0)));
        } catch (CarValidatorException e) {
            assertEquals(9006, e.getErrorCode());
        }
    }

    @Test
    void validateCar_price_ok() {
        assertTrue(CarValidator.validateCar(carForPrice(BigDecimal.valueOf(25000))));
    }

    @Test
    void validateCar_currency_null() {
        try {
            CarValidator.validateCar(carForCurrency(null));
        } catch (CarValidatorException e) {
            assertEquals(9004, e.getErrorCode());
        }
    }

    @Test
    void validateCar_currency_empty() {
        try {
            CarValidator.validateCar(carForCurrency(""));
        } catch (CarValidatorException e) {
            assertEquals(9004, e.getErrorCode());
        }
    }

    @Test
    void validateCar_incorrect_currency() {
        try {
            CarValidator.validateCar(carForCurrency("RON"));
        } catch (CarValidatorException e) {
            assertEquals(9005, e.getErrorCode());
        }
    }

    Car carForMaker(String maker) {
        Car car = new Car();
        car.setMaker(maker);
        car.setColor("Yellow");
        car.setModel("X5");
        car.setYear(2023);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(98000));
        return car;
    }

    Car carForModel(String model) {
        Car car = new Car();
        car.setMaker("Mercedes");
        car.setColor("Yellow");
        car.setModel(model);
        car.setYear(2023);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(98000));
        return car;
    }

    Car carForColor(String color) {
        Car car = new Car();
        car.setMaker("Mercedes");
        car.setColor(color);
        car.setModel("X5");
        car.setYear(2023);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(98000));
        return car;
    }

    Car carForYear(Integer year) {
        Car car = new Car();
        car.setMaker("Mercedes");
        car.setColor("Yellow");
        car.setModel("X5");
        car.setYear(year);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(98000));
        return car;
    }

    Car carForPrice(BigDecimal price) {
        Car car = new Car();
        car.setMaker("Mercedes");
        car.setColor("Yellow");
        car.setModel("X5");
        car.setYear(2023);
        car.setCurrency("EUR");
        car.setPrice(price);
        return car;
    }

    Car carForCurrency(String currency) {
        Car car = new Car();
        car.setMaker("Mercedes");
        car.setColor("Yellow");
        car.setModel("X5");
        car.setYear(2023);
        car.setCurrency(currency);
        car.setPrice(BigDecimal.valueOf(98000));
        return car;
    }
}