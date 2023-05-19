package ro.andu.curs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.andu.curs.model.Car;

public interface DbCarRepository extends JpaRepository<Car, Long>{
    
}
