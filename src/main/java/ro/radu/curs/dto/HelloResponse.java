package ro.radu.curs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloResponse {
    @JsonProperty("a")
    private String a;

    @JsonProperty("b")
    private String b;
}
