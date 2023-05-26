package ro.cristi.curs.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import ro.cristi.curs.model.Car;

@Profile("database")
public interface DbCarRepository extends JpaRepository<Car,Long>{
    
}
