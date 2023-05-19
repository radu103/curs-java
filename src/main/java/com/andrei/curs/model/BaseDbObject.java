package com.andrei.curs.model;

import java.time.Instant;

import lombok.Data;

@Data
public class BaseDbObject {

    private String createdBy;
    private Instant created;
}
