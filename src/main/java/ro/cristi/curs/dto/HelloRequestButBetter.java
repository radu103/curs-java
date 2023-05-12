package ro.cristi.curs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloRequestButBetter {
    
    @JsonProperty("motivational")
    String motivational;
    @JsonProperty("demotivational")
    String demotivational;
}
