package com.andrei.curs.dto;

import lombok.Data;

@Data
public class VanDto extends CarDto {

    private String maxCapacity;
    private String bootCapacity;
}
