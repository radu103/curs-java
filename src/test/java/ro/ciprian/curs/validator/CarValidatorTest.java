package ro.ciprian.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ro.ciprian.curs.exception.CarValidatorException;
import ro.ciprian.curs.model.Car;

@SpringBootTest
public class CarValidatorTest {

    @Test
    void carValidatorTest_maker_empty(){
        Car car1 = new Car();
        car1.setMaker("");
        try{
            CarValidator.validateCarMaker(car1.getMaker());
        } catch(CarValidatorException e){
            assertEquals(90001, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_maker_nlength(){
        Car car1 = new Car();
        car1.setMaker("hbehfidfhbdsfhvdbhdvbhjvdsbhdvhj");
        try{
            CarValidator.validateCarMaker(car1.getMaker());
        } catch(CarValidatorException e){
            assertEquals(90002, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_maker_lowercase(){
        Car car1 = new Car();
        car1.setMaker("case");
        try{
            CarValidator.validateCarMaker(car1.getMaker());
        } catch(CarValidatorException e){
            assertEquals(90003, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_maker_true(){
        Car car1 = new Car();
        car1.setMaker("Audi");
        assertTrue(CarValidator.validateCarMaker(car1.getMaker()));
    }
    @Test
    void carValidatorTest_maker_null(){
        Car car1 = new Car();
        car1.setMaker(null);
        try{
            CarValidator.validateCar(car1);
        } catch(CarValidatorException e){
            assertEquals(90001, e.getErrorCode());
        }
    }


    @Test
    void carValidatorTest_model_null(){
        Car car1 = new Car();
        car1.setModel(null);
        try{
            CarValidator.validateCarModel(car1.getModel());
        } catch(CarValidatorException e){
            assertEquals(90011, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_model_isEmpty(){
        Car car1 = new Car();
        car1.setModel("");
        try{
            CarValidator.validateCarModel(car1.getModel());
        } catch(CarValidatorException e){
            assertEquals(90011, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_model_length(){
        Car car1 = new Car();
        car1.setModel("Asdfeargrsadfsdafgew");
        try{
            CarValidator.validateCarModel(car1.getModel());
        } catch(CarValidatorException e){
            assertEquals(90012, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_model_lowercase(){
        Car car1 = new Car();
        car1.setModel("test");
        try{
            CarValidator.validateCarModel(car1.getModel());
        } catch(CarValidatorException e){
            assertEquals(90013, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_model_true(){
        Car car1 = new Car();
        car1.setModel("A8");
        assertTrue(CarValidator.validateCarModel(car1.getModel()));
    }


    @Test
    void carValidatorTest_color_null(){
        Car car1 = new Car();
        car1.setColor(null);
        try{
            CarValidator.validateCarColor(car1.getColor());
        } catch(CarValidatorException e){
            assertEquals(90021, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_color_isEmpty(){
        Car car1 = new Car();
        car1.setColor("");
        try{
            CarValidator.validateCarColor(car1.getColor());
        } catch(CarValidatorException e){
            assertEquals(90021, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_color_lowerCase(){
        Car car1 = new Car();
        car1.setColor("brown");
        try{
            CarValidator.validateCarColor(car1.getColor());
        } catch(CarValidatorException e){
            assertEquals(90023, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_color_length(){
        Car car1 = new Car();
        car1.setColor("Sfdsfaguiherhgiuwhgiuedfhadsgf");
        try{
            CarValidator.validateCarColor(car1.getColor());
        } catch(CarValidatorException e){
            assertEquals(90022, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_color_true(){
        Car car1 = new Car();
        car1.setColor("Brown");
        assertTrue(CarValidator.validateCarColor(car1.getColor()));
    }


    @Test
    void carValidatorTest_year_null(){
        Car car1 = new Car();
        car1.setYear(null);
        try{
            CarValidator.validateCarYear(car1.getYear());
        } catch (CarValidatorException e){
            assertEquals(90031, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_year_old(){
        Car car1 = new Car();
        car1.setYear(1800);
        try{
            CarValidator.validateCarYear(car1.getYear());
        } catch (CarValidatorException e){
            assertEquals(90032, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_year_notReleased(){
        Car car1 = new Car();
        car1.setYear(2030);
        try{
            CarValidator.validateCarYear(car1.getYear());
        } catch (CarValidatorException e){
            assertEquals(90033, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_year_true(){
        Car car1 = new Car();
        car1.setYear(2020);
        assertTrue(CarValidator.validateCarYear(car1.getYear()));
    }

    @Test
    void carValidatorTest_price_null(){
        Car car1 = new Car();
        car1.setPrice(null);
        try{
            CarValidator.validateCarPrice(car1.getPrice());
        } catch (CarValidatorException e){
            assertEquals(90041, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_price_minim(){
        Car car1 = new Car();
        var pricetest = BigDecimal.valueOf(100);
        car1.setPrice(pricetest);
        try{
            CarValidator.validateCarPrice(car1.getPrice());
        } catch (CarValidatorException e){
            assertEquals(90042, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_price_maximum(){
        Car car1 = new Car();
        var pricetest = BigDecimal.valueOf(909090909);
        car1.setPrice(pricetest);
        try{
            CarValidator.validateCarPrice(car1.getPrice());
        } catch (CarValidatorException e){
            assertEquals(90043, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_price_true(){
        Car car1 = new Car();
        var pricetest = BigDecimal.valueOf(12345);
        car1.setPrice(pricetest);
        assertTrue(CarValidator.validateCarPrice(car1.getPrice()));
    }

    @Test
    void carValidatorTest_mileage_null(){
        Car car1 = new Car();
        car1.setMileage(null);
        try{
            CarValidator.validateCarMileage(car1.getMileage());
        } catch (CarValidatorException e){
            assertEquals(90051, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_mileage_high(){
        Car car1 = new Car();
        car1.setMileage(502);
        try{
            CarValidator.validateCarMileage(car1.getMileage());
        } catch (CarValidatorException e){
            assertEquals(90052, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_mileage_true(){
        Car car1 = new Car();
        car1.setMileage(100);
        assertTrue(CarValidator.validateCarMileage(car1.getMileage()));
    }

    @Test
    void carValidatorTest_currency_null(){
        Car car1 = new Car();
        car1.setCurrency(null);
        try{
            CarValidator.validateCarCurrency(car1.getCurrency());
        } catch (CarValidatorException e){
            assertEquals(90061, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_currency_isEmpty(){
        Car car1 = new Car();
        car1.setCurrency("");
        try{
            CarValidator.validateCarCurrency(car1.getCurrency());
        } catch (CarValidatorException e){
            assertEquals(90061, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_currency_acceptable(){
        Car car1 = new Car();
        car1.setCurrency("GBP");
        try{
            CarValidator.validateCarCurrency(car1.getCurrency());
        } catch (CarValidatorException e){
            assertEquals(90062, e.getErrorCode());
        }
    }
    @Test
    void carValidatorTest_currency_true(){
        Car car1 = new Car();
        car1.setCurrency("USD");
        assertTrue(CarValidator.validateCarCurrency(car1.getCurrency()));
    }
}
