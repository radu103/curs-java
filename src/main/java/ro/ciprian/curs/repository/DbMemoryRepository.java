package ro.ciprian.curs.repository;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;
import ro.ciprian.curs.model.Car;

@UtilityClass
public class DbMemoryRepository {
    public static List<Car> carList=new ArrayList<>();
}
