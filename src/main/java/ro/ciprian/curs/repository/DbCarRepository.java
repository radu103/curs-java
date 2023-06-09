package ro.ciprian.curs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.ciprian.curs.model.Car;

public interface DbCarRepository extends JpaRepository<Car, Long>{
    public static List<Car> getLocalAllCars() {
        return DbMemoryRepository.carList;
    }
}