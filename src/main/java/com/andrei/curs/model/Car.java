package com.andrei.curs.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Car {
    private Integer id;
    private String maker;
    private String model;
    private Integer power;
    private String color;
    private Integer year;
    private BigDecimal price;
    private String currency;
}