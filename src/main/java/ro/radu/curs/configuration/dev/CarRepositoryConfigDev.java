package ro.radu.curs.configuration.dev;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;
import ro.radu.curs.model.Car;
import ro.radu.curs.Repository.*;

@Configuration
@Profile("dev")
public class CarRepositoryConfigDev {

    @Bean
    public void LoadData(){

        public List<Car> getAlCars(){
            List<Car> list = new ArrayList<>();
    
            Car car = new Car();
            car.setMaker("BMW");
            car.setColor("yellow");
            car.setYear(2023);
            car.setModel("x5");
            car.setCurrency("EUR");
            car.setPrice(BigDecimal.valueOf(980000));
            list.add(car);
            
            MemoryRepository.carList = list;
        }
    }
    
}
