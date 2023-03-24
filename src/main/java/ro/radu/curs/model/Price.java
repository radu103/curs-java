package ro.radu.curs.model;

import java.math.BigDecimal;

import lombok.Data;



@Data
public class Price {
    private BigDecimal price;
    private String currency;
}
