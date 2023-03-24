package ro.radu.curs.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.radu.curs.Repository.CarRepository;
import ro.radu.curs.dto.CarDto;
import ro.radu.curs.mapper.CarMapper;
import ro.radu.curs.model.Car;
import ro.radu.curs.service.CarService;

import java.util.*;

@RestController
@RequestMapping("/v1")
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

    @GetMapping("/car/list/early")
    public List<CarDto> getEarlierCars(@RequestParam Integer years) {
        List<Car> list = carService.getEarlierCars(years);
        return carMapper.map(list);
    }

}
