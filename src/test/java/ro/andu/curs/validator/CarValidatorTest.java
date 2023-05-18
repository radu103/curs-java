package ro.andu.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ro.andu.curs.exception.CarValidatorException;
import ro.andu.curs.model.Car;

@SpringBootTest
public class CarValidatorTest {

    Car car = new Car();
    void initCar() {
        car.setMaker("Ford");
        car.setModel("Focus");
        car.setColor("Turqouse");
        car.setYear(2024);
        car.setPrice(new BigDecimal(10000));
        car.setCurrency("EUR");
    }
    
    @Test
    void testValidateCarsMaker_exception(){
        initCar();
        car.setMaker(null);
        try {
            CarValidator.validateCar(car);;
        } catch (CarValidatorException e) {
            assertEquals(90001, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsMakerLenght_exception() {
        initCar();
        car.setMaker("aaaaaaaaaaaaaaaa");
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90002, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsMakerUppercase_exception(){
        initCar();
        car.setMaker("name");
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90003, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsMakerIsOk_exception(){
        initCar();
        car.setMaker("Ford");
        assertTrue(CarValidator.validateCar(car));
    }

    //---------------------------------

    @Test
    void testValidateCarsModel_exception(){
        initCar();
        car.setModel(null);
        try {
            CarValidator.validateCar(car);;
        } catch (CarValidatorException e) {
            assertEquals(90011, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsModelLenght_exception() {
        initCar();
        car.setModel("aaaaaaaaaaaaaaaa");
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90012, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsModelUppercase_exception(){
        initCar();
        car.setModel("name");
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90013, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsModelIsOk_exception(){
        initCar();
        car.setModel("Focus");
        assertTrue(CarValidator.validateCar(car));
    }

    //---------------------------------

    @Test
    void testValidateCarsColor_exception(){
        initCar();
        car.setColor(null);
        try {
            CarValidator.validateCar(car);;
        } catch (CarValidatorException e) {
            assertEquals(90021, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsColorLenght_exception() {
        initCar();
        car.setColor("aaaaaaaaaaaaaaaa");
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90022, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsColorUppercase_exception(){
        initCar();
        car.setColor("name");
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90023, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsColorIsOk_exception(){
        initCar();
        car.setColor("Turqouse");
        assertTrue(CarValidator.validateCar(car));
    }

    //---------------------------------

    @Test
    void testValidateCarsYear_exception(){
        initCar();
        car.setYear(0);
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90031, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsYearOlder_exception() {
        initCar();
        car.setYear(1800);
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90032, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsYearNewer_exception(){
        initCar();
        car.setYear(2050);
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90033, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsYearIsOk_exception(){
        initCar();
        car.setYear(2024);
        assertTrue(CarValidator.validateCar(car));
    }

    //---------------------------------

    @Test
    void testValidateCarsPrice_exception(){
        initCar();
        car.setPrice(new BigDecimal(0));
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90041, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsPriceExists_exception() {
        initCar();
        car.setPrice(new BigDecimal(1));
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90042, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsPriceIsOk_exception(){
        initCar();
        car.setPrice(new BigDecimal(10000));
        assertTrue(CarValidator.validateCar(car));
    }

    //---------------------------------

    @Test
    void testValidateCarsCurrency_exception(){
        initCar();
        car.setCurrency(null);
        try {
            CarValidator.validateCar(car);;
        } catch (CarValidatorException e) {
            assertEquals(90051, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsCurrencyValidity_exception() {
        initCar();
        car.setCurrency("aaaaaaaaaaaaaaaa");
        try {
            CarValidator.validateCar(car);
        } catch (CarValidatorException e) {
            assertEquals(90052, e.getErrorCode());
        }
    }
    @Test
    void testValidateCarsCurrencyIsOk_exception(){
        initCar();
        car.setCurrency("EUR");
        assertTrue(CarValidator.validateCar(car));
    }

    //---------------------------------
}
