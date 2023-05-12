package ro.ciprian.curs.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            CarValidator.validateCar(car1);
        } catch(CarValidatorException e){
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    void carValidatorTest_maker_nlength(){
        Car car1 = new Car();
        car1.setMaker("hbehfidfhbdsfhvdbhdvbhjvdsbhdvhj");
        try{
            CarValidator.validateCar(car1);
        } catch(CarValidatorException e){
            assertEquals(90002, e.getErrorCode());
        }
    }

    @Test
    void carValidatorTest_maker_lowercase(){
        Car car1 = new Car();
        car1.setMaker("case");
        try{
            CarValidator.validateCar(car1);
        } catch(CarValidatorException e){
            assertEquals(90003, e.getErrorCode());
        }
    }

    @Test
    void carValidatorTest_true(){
        Car car1 = new Car();
        car1.setMaker("Audi");
        assertTrue(CarValidator.validateCar(car1));
    }

    @Test
    void carValidatorTest_null(){
        Car car1 = new Car();
        car1.setMaker(null);
        try{
            CarValidator.validateCar(car1);
        } catch(CarValidatorException e){
            assertEquals(90001, e.getErrorCode());
        }
    }
}
