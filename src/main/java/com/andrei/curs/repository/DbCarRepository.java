package com.andrei.curs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrei.curs.model.Car;

public interface DbCarRepository extends JpaRepository<Car, Long> {

}
