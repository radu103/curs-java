package ro.ciprian.curs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloRespone {
    @JsonProperty("a")
    private String a;
    
    @JsonProperty("b")
    private String b;
}
