package ro.cristi.curs.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class VanDto extends CarDto{
    
    private String capacity;
    private Integer payload;
}
