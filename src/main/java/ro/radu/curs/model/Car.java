package ro.radu.curs.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "cars", indexes = {@Index(name = "cars_years_idx", columnList = "year"),
                                 @Index(name = "cars_maker_model_idx", columnList = "maker,model")})
public class Car{

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

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "Hp")
    private Integer Hp;

    @Column(name = "active", columnDefinition = "boolean default true")
    private Boolean active;
}