package ro.raffa.curs.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.raffa.curs.dto.CarDto;
import ro.raffa.curs.mapper.CarMapper;
import ro.raffa.curs.model.Car;
import ro.raffa.curs.repository.CarRepository;
import ro.raffa.curs.service.CarServiceMemory;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    CarServiceMemory carService;

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
}
