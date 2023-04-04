package ro.raffa.curs.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Car {
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private BigDecimal price;
    private String currency;
}