package ro.cristi.curs.dto;

import lombok.Data;

@Data
public class VanDto extends CarDto{
    
    private String capacity;
    private Integer payload;
}
