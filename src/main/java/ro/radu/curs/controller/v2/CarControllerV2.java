package ro.radu.curs.controller.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.radu.curs.dto.CarDto;
import ro.radu.curs.mapper.CarMapper;
import ro.radu.curs.model.Car;
import ro.radu.curs.repository.DbCarRepository;

@RestController
@RequestMapping("/v2")
public class CarControllerV2 {
    
    @Autowired
    DbCarRepository carRepository;

    @Autowired
    CarMapper mapper;

    @GetMapping("/car/list")
    public List<Car> getCars() {
        List<Car> list = carRepository.findAll();
        return list;
    }

    @PostMapping("/car/update/{id}")
    public Car addCar(@RequestBody CarDto carDto, @PathVariable Long id) {
        carDto.setId(id);
        Car car = mapper.toEntity(carDto);
        return carRepository.save(car);
    }
}
