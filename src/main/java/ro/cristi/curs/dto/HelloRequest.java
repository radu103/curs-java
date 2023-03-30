package ro.cristi.curs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloRequest {

    @JsonProperty("input")
    String input;
}
