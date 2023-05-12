package ro.andu.curs.controller.v1;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.andu.curs.configuration.dev.CarRepositoryConfigDev;
import ro.andu.curs.configuration.local.CarRepositoryConfigLocal;
import ro.andu.curs.dto.CarDto;
import ro.andu.curs.mapper.CarMapper;
import ro.andu.curs.model.Car;
import ro.andu.curs.repository.CarRepository;
import ro.andu.curs.service.CarServiceMemory;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarServiceMemory carService;

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
    @GetMapping(path = "car/list/add")
    public void addCars(@RequestParam String maker, @RequestParam String model, @RequestParam String color, @RequestParam Integer year, @RequestParam Integer price) {
        carService.addCars(maker,model,color,year,price);
    }
    @GetMapping(path = "car/list/reset")
    public void resetCars(HttpServletResponse httpResponse) {
        carService.reset();
        try {
            httpResponse.sendRedirect("/v1/car/list");
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
