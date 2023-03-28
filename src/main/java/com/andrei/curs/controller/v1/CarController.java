package com.andrei.curs.controller.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.curs.dto.CarDto;
import com.andrei.curs.mapper.CarMapper;
import com.andrei.curs.model.Car;
import com.andrei.curs.repository.CarRepository;
import com.andrei.curs.service.CarService;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarMapper carMapper;

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
    public List<CarDto> getOldCars(@RequestParam Integer val) {
        List<Car> list = carService.getOldCars(val);
        return carMapper.map(list);
    }

    @GetMapping("/car/list/tuned")
    public List<CarDto> getTunedCars(@RequestParam Integer step, @RequestParam Integer number) {
        List<Car> list = carService.getTunedCar(step, number);
        return carMapper.map(list);
    }
}