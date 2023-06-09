package ro.andu.curs.controller.v2;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.andu.curs.repository.DbCarRepository;
import ro.andu.curs.service.CarServiceMemory;
import ro.andu.curs.dto.CarDto;
import ro.andu.curs.mapper.CarMapper;
import ro.andu.curs.model.Car;

@RestController
@RequestMapping("/v2")
public class CarControllerV2 {
    
    @Autowired
    DbCarRepository carRepository;

    @Autowired
    CarServiceMemory carService;

    @Autowired
    CarMapper mapper;


    @GetMapping(path = "/car/list")
    public List<Car> getCars() {
        List<Car> list = DbCarRepository.getLocalAllCars();
        List<Car> tempList = carRepository.findAll();
        if (!tempList.isEmpty()) {
            list = tempList;
            DbCarRepository.setLocalCars(list);
        }
        return list;
    }
    @GetMapping(path = "/car/list/expensive")
    public List<Car> getExpensiveCars(@RequestParam Integer percent) {
        return carService.getExpensiveCars(percent);
    }
    @GetMapping(path = "/car/list/cheap")
    public List<Car> getCheaperCars(@RequestParam Integer value) {
        return carService.getCheaperCars(value);
    }
    @GetMapping(path = "car/list/reset")
    public void resetCars(HttpServletResponse httpResponse) {
        carService.reset();
        try {
            httpResponse.sendRedirect("/v2/car/list");
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
    @PostMapping("car/add")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
    @PostMapping("car/delete")
    public Car deleteCar(@RequestBody Car car) {
        carRepository.delete(car);
        return null;
    }
    @PostMapping("/car/update/{id}")
    public Car updateCar(@RequestBody CarDto carDto, @PathVariable Long id) {
        carDto.setId(id);
        Car car = mapper.toEntity(carDto);
        return carRepository.save(car);
    }
}
