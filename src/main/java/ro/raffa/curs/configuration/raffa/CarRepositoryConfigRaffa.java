package ro.raffa.curs.configuration.raffa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ro.raffa.curs.model.Car;
import ro.raffa.curs.repository.MemoryRepository;

@Configuration
@Profile("raffa")
public class CarRepositoryConfigRaffa {

    List<Car> list;
    @Bean
    public void loadDataRaffa() {
        list=new ArrayList<Car>();
        addCarIntoList("BMW","21C" ,"Green" ,2019 ,BigDecimal.valueOf(200000),"EUR" ,4,2 ,23 );
        addCarIntoList("Toyota", "Chinese-Version", "Skye", 2021, BigDecimal.valueOf(302100), "EUR", 4, 4, 23);
        addCarIntoList("Tesla", "Truck","Cream" ,2022 ,BigDecimal.valueOf(199999.99) ,"EUR" ,2 ,4 ,3 );
        addCarIntoList("Tesla", "3-Wheelie", "Rose", 2023, BigDecimal.valueOf(60000), "EUR", 3, 2, 4);
        addCarIntoList("Mustang", "Thanos", "Purple", 2023, BigDecimal.valueOf(9000000), "EUR", 6, 4, 1);

        MemoryRepository.carList=list;
    }

    private void addCarIntoList(String maker,String model,String color,Integer year,BigDecimal price,String currency,Integer numberOfWheels,Integer numberOfDoors,Integer numberInStock) 
    {
        Car c=new Car();
        c.setMaker(maker);
        c.setModel(model);
        c.setColor(color);
        c.setYear(year);
        c.setPrice(price);
        c.setCurrency(currency);
        c.setNumberOfWheels(numberOfWheels);
        c.setNumberOfDoors(numberOfDoors);
        c.setNumberInStock(numberInStock);
        
        list.add(c);
    }   
}
