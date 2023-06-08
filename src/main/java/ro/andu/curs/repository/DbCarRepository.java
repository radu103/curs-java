package ro.andu.curs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.andu.curs.model.Car;

@Repository
public interface DbCarRepository extends JpaRepository<Car, Long>{
    public static List<Car> getLocalAllCars() {
        return DbMemoryRepository.carList;
    }
    public static void setLocalCars(List<Car> list) {
        DbMemoryRepository.carList=list;
    }
}
