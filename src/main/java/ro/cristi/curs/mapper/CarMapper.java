package ro.cristi.curs.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ro.cristi.curs.dto.CarDto;
import ro.cristi.curs.dto.PriceDto;
import ro.cristi.curs.model.Car;

@Component
public class CarMapper {
    
    public CarDto map(Car car) {

        CarDto carDto = new CarDto();
        carDto.setMaker(car.getMaker());
        carDto.setModel(car.getModel());
        carDto.setYear(car.getYear());
        carDto.setColor(car.getColor());

        PriceDto priceDto = new PriceDto();
        priceDto.setPrice(car.getPrice());
        priceDto.setCurrency(car.getCurrency());

        carDto.setPrice(priceDto);

        return carDto;
    }

    public List<CarDto> map(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(map(car));
        }
        return carDtos;
    }
}

