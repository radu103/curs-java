package ro.radu.curs.repository;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;
import ro.radu.curs.model.Car;

@UtilityClass
public class MemoryRepository {
    public static List<Car> carList = new ArrayList<>();
}
