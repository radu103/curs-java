package ro.cristi.curs.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SuvDto extends CarDto{
    private Integer transmission;
    private Integer horsePower;
    
}
