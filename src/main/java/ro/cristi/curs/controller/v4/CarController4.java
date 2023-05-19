package ro.cristi.curs.controller.v4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cristi.curs.model.Car;
import ro.cristi.curs.repository.*;

import java.util.*;

@RestController
@RequestMapping("/v4")
public class CarController4 {
    
    @Autowired
    DbCarRepository carRepository;

    @GetMapping("/car/list")
    public List<Car> getCars(){
        List<Car> list = carRepository.findAll();
        return list;
    }

    @PostMapping("/car/add")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
}
