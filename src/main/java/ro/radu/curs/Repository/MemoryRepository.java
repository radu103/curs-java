package ro.radu.curs.Repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import lombok.experimental.UtilityClass;
import ro.radu.curs.model.Car;

@Repository
@UtilityClass
public class MemoryRepository {
    public static List<Car> carList = new ArrayList<>();
}
