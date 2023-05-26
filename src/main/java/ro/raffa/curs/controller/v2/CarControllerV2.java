package ro.raffa.curs.controller.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raffa.curs.model.Car;
import ro.raffa.curs.repository.DbCarRepository;

@RestController
@RequestMapping("/v2")
public class CarControllerV2 {

    @Autowired
    DbCarRepository carRepository;
    
    @GetMapping("/car/list")
    public List<Car> getCars() {
        List<Car> list=carRepository.findAll();
        return list;
    }

    @PostMapping("/car/add")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }






}
