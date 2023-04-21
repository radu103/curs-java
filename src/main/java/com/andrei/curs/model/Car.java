package com.andrei.curs.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Car {
    private Integer id;
    private Integer power;
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private BigDecimal price;
    private String currency;
}