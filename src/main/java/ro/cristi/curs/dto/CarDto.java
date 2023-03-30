package ro.cristi.curs.dto;

import lombok.Data;

@Data
public class CarDto {
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private Boolean isManual;
    private Double consumption; //as liters per 100km or kwh for electric

    private PriceDto price;
}
