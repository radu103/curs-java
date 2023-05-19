package ro.raffa.curs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.raffa.curs.model.Car;

public interface DbCarRepository extends JpaRepository<Car, Long>{

    
    
}
