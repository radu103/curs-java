package ro.cristi.curs.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SedanDto extends CarDto{
    private Integer doors;
    private Boolean isElectric;
}
