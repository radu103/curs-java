package ro.radu.curs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ro.radu.curs.model.Car;

@Service
@Profile("zero")
public class CarServiceZeroImpl implements CarServiceMemory {

    @Override
    public List<Car> getExpensiveCars(Integer percent) {
        return new ArrayList<>();
    }
}
