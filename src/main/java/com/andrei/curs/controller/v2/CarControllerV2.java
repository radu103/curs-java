package com.andrei.curs.controller.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.curs.model.Car;
import com.andrei.curs.repository.DbCarRepository;

import java.util.*;

@RestController
@RequestMapping("/v2")
public class CarControllerV2 {

    @Autowired
    DbCarRepository carRepository;

    @GetMapping("/car/list")
    public List<Car> getCars() {
        List<Car> list = carRepository.findAll();
        return list;
    }

    @PostMapping("/car/add")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

}
