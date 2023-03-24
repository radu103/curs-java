package ro.radu.curs.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Data;
import ro.radu.curs.model.Car;

@Data
@Repository
public class CarRepository {

    public static List<Car> list = new ArrayList();
    
    public List<Car>
}
