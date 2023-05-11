package ro.cristi.curs.controller.v3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.cristi.curs.Repository.CarRepository;
import ro.cristi.curs.dto.CarDto;
import ro.cristi.curs.mapper.CarMapper;
import ro.cristi.curs.model.Car;
import ro.cristi.curs.service.CarService;

import java.util.*;

@RestController
@RequestMapping("/v3")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarMapper carMapper;

    @Autowired
    CarService carService;

    @GetMapping("/car/list")
    public List<CarDto> getCars() {
        List<Car> list = carRepository.getAllCars();
        return carMapper.map(list);
    }

    @GetMapping("/car/list/expensive")
    public List<CarDto> getExpensiveCars(@RequestParam Integer percent) {
        List<Car> list = carService.getExpensiveCars(percent);
        return carMapper.map(list);
    }

    @GetMapping("/car/list/old")
    public List<CarDto> getOlderCars(@RequestParam Integer years) {
        List<Car> list = carService.getOlderCars(years);
        return carMapper.map(list);
    }

    @GetMapping("/car/list/efficient")
    public List<CarDto> getEfficientCars(@RequestParam Integer units) {
        List<Car> list = carService.getEfficientCars(units);
        return carMapper.map(list);
    }

}
