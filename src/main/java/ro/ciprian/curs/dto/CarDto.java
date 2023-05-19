package ro.ciprian.curs.dto;

import lombok.Data;

@Data
public class CarDto {
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private Integer mileage;
    private PriceDto price;
}