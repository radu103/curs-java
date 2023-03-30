package ro.cristi.curs.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Car{
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private Boolean isManual;
    private Double consumption; 
    
    private BigDecimal price;
    private String currency;
}
