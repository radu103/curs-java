package ro.ciprian.curs.controller.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.ciprian.curs.model.Car;
import ro.ciprian.curs.repository.DbCarRepostiory;

@RestController
@RequestMapping("/v2")
public class CarControllerV2 {

    @Autowired
    DbCarRepostiory carRepostiory;

    @GetMapping("car/list")
    public List<Car> getCars() {
        List<Car> list = carRepostiory.findAll();
        return list;
    }

    @PostMapping("car/add")
    public Car addCar(@RequestBody Car car) {
        return carRepostiory.save(car);
    }
}
