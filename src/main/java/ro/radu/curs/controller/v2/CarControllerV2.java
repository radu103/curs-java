package ro.radu.curs.controller.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.radu.curs.model.Car;
import ro.radu.curs.repository.DbCarRepository;

@RestController
@RequestMapping("/v2")
public class CarControllerV2 {

    @Autowired
    DbCarRepository carRepository;

    @GetMapping("/car/list")
    public List<Car> getCars(){
        List<Car> list = carRepository.findAll();
        return list;
    }

    @PostMapping("/car/add")
    public Car addCar(@RequestBody Car car){
        return carRepository.save(car);
    }
    
    @PostMapping("/car/update/{id}")
    public Car updateById(@RequestBody Car car, @PathVariable Integer id){
        Long id2 = Long.valueOf(id);
        Car car1 = carRepository.findById(id2).get();
        car1.setColor(car.getColor());
        car1.setCurrency(car.getCurrency());
        car1.setMaker(car.getMaker());
        car1.setModel(car.getModel());
        car1.setPrice(car.getPrice());
        car1.setYear(car.getYear());
        return carRepository.save(car1);
    }
}
