package com.robert.curs.dto;

import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HelloList {

    @JsonProperty
    private HashMap<String, ArrayList<String>> maps;
}