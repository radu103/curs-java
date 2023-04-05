package ro.raffa.curs.dto;

import lombok.Data;

/*
 * This class is used to transfer data from the client to the server.
 */
@Data
public class CarDto {
    private String maker;
    private String model;
    private String color;
    private Integer year;
    private PriceDto price;

    /// ssss
}
