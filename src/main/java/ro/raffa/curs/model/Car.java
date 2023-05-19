package ro.raffa.curs.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="cars")
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseDbObject{

    @Column(name="maker")
    private String maker;

    @Column(name="model")
    private String model;

    @Column(name="color")
    private String color;

    @Column(name="year")
    private Integer year;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="currency")
    private String currency;
}