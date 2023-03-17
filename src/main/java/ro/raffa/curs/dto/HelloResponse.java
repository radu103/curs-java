package ro.raffa.curs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloResponse {
    @JsonProperty
    private String a;

    @JsonProperty
    private String b;
}
