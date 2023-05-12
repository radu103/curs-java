package ro.cristi.curs.dto;

import lombok.Data;

@Data
public class SedanDto extends CarDto{
    private Integer doors;
    private Boolean isElectric;
}

