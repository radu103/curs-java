package ro.ciprian.curs.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.ciprian.curs.dto.CarDto;
import ro.ciprian.curs.mapper.CarMapper;
import ro.ciprian.curs.model.Car;
import ro.ciprian.curs.repository.CarRepository;
import ro.ciprian.curs.service.CarService;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Autowired
    CarMapper carMapper;

    @GetMapping(path = "/car/list")
    public List<CarDto> getCars() {
        List<Car> list = carRepository.getAllCars();
        return carMapper.map(list);
    }
    @GetMapping(path = "/car/list/expensive")
    public List<CarDto> getExpensiveCars(@RequestParam Integer percent) {
        return carMapper.map(carService.getExpensiveCars(percent));
    }
    @GetMapping(path = "/car/list/old")
    public List<CarDto> getOlderCars(@RequestParam Integer value) {
        return carMapper.map(carService.getOlderCars(value));
    }
    @GetMapping(path = "/car/list/cheap")
    public List<CarDto> getCheaperCars(@RequestParam Integer value) {
        return carMapper.map(carService.getCheaperCars(value));
    }
}
