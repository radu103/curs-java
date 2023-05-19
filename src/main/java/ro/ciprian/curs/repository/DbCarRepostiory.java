package ro.ciprian.curs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.ciprian.curs.model.Car;

public interface DbCarRepostiory extends JpaRepository<Car, Long>{
    
}
