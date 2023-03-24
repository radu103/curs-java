package ro.andu.curs.dto;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloResponseList {
    
    @JsonProperty
    ArrayList<String> a;

}
