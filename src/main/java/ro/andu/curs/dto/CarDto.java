package ro.andu.curs.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private PriceDto price;
}