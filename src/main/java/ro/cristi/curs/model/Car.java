package ro.cristi.curs.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cars")
public class Car {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "maker")
    private String maker;

    @Column(name = "model")
    private String model;
    
    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private Integer year;

    @Column(name = "isManual")
    private Boolean isManual;

    @Column(name = "consumption")
    private Double consumption; 

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    private String currency;
}
