package ro.radu.curs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.radu.curs.model.Car;

public interface DbCarRepository extends JpaRepository<Car,Long>{
    
}
