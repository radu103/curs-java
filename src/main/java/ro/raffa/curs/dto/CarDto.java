package ro.raffa.curs.dto;

import lombok.Data;

@Data
public class CarDto {
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private PriceDto price;

    // TEMA
    private Integer numberOfWheels;
    private Integer numberOfDoors;
    private Integer numberInStock;

}
