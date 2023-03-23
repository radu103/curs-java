package com.robert.curs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloRequest {

    @JsonProperty("a")
    private String a;

    @JsonProperty("b")
    private String b;
}