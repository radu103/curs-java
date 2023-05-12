package com.andrei.curs.repository;

import java.util.ArrayList;
import java.util.List;

import com.andrei.curs.model.Car;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MemoryRepository {
    public static List<Car> carList = new ArrayList<>();
}
