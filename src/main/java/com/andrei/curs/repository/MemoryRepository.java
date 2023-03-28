package com.andrei.curs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.andrei.curs.model.Car;

@Repository
public class MemoryRepository {
    public static List<Car> carList = new ArrayList<>();
}