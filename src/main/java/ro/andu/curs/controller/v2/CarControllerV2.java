package ro.andu.curs.controller.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.andu.curs.repository.DbCarRepository;

import ro.andu.curs.model.Car;

@RestController
@RequestMapping("/v2")
public class CarControllerV2 {
    
    @Autowired
    DbCarRepository carRepository;

    @GetMapping(path = "/car/list")
    public List<Car> getCars() {
        List<Car> list = DbCarRepository.getLocalAllCars();
        if (list.isEmpty()) {
            list = carRepository.findAll();
        }
        return list;
    }
    
    @PostMapping("car/add")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
}
