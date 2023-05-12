package com.andrei.curs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.andrei.curs.exception.CarValidatorException;
import com.andrei.curs.model.Car;
import com.andrei.curs.validator.CarValidator;

@SpringBootTest
@ActiveProfiles("local")
public class CarValidatorTest {

    Car createCar(String maker){
        Car car = new Car();
        car.setMaker(maker);
        car.setColor("a");
        car.setModel("m");
        car.setYear(2023);
        car.setCurrency("EUR");
        car.setPrice(BigDecimal.valueOf(98000));

        return car;
}
    
    @Test
    void testValidateCarNull()throws CarValidatorException{
        
        try{
            Car car = createCar(null);
            CarValidator.validateCarMaker(car.getMaker());
        }catch(CarValidatorException e){
            assertEquals(90001, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarLength(){
        try{
            Car car = createCar("ufjfhfhfhfhfhfhff");
            CarValidator.validateCarMaker(car.getMaker());
        }catch(CarValidatorException e){
            assertEquals(90002, e.getErrorCode());
        }
    }

    @Test
    void testValidateCarLowerCase(){
        try{
            Car car = createCar("maker");
            CarValidator.validateCarMaker(car.getMaker());
        }catch(CarValidatorException e){
            assertEquals(90003, e.getErrorCode());
        }
    }
}