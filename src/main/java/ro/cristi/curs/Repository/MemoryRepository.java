package ro.cristi.curs.Repository;

import java.util.*;

import lombok.experimental.UtilityClass;

import ro.cristi.curs.model.Car;

@UtilityClass
public class MemoryRepository {
    public static List<Car> carList = new ArrayList<>();
}
