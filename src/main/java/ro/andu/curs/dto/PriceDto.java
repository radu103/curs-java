package ro.andu.curs.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PriceDto {
    private BigDecimal price;
    private String currency;
}
