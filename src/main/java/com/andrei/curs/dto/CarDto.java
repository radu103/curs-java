package com.andrei.curs.dto;

import lombok.Data;

@Data
public class CarDto {

    private Integer id;
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private Integer power;
    private Integer torque;

    private PriceDto price;
}
