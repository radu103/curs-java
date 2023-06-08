package ro.cristi.curs.controller.v4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.cristi.curs.exception.CarControllerException;
import ro.cristi.curs.model.Car;
import ro.cristi.curs.repository.DbCarRepository;

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

    @PostMapping("/car/update")
    public Car updateCarById(@RequestBody Car car, @RequestParam Integer id) throws CarControllerException{
        Long id2 = Long.valueOf(id);
        Car car2 =  carRepository.findById(id2).get();
        if(car2==null) throw new CarControllerException(60001, "Id not found");
        car2.setColor(car.getColor());
        car2.setConsumption(car.getConsumption());
        car2.setCurrency(car.getCurrency());
        car2.setIsManual(car.getIsManual());
        car2.setMaker(car.getMaker());
        car2.setModel(car.getModel());
        car2.setPrice(car.getPrice());
        car2.setYear(car.getYear());
        return carRepository.save(car2);
    } 
}

