package ro.cristi.curs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.cristi.curs.model.Car;

public interface DbCarRepository extends JpaRepository<Car,Long>{
    
}
