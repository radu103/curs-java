package com.andrei.curs.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CarValidatorException extends RuntimeException {

    private Integer errorCode;

    public CarValidatorException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}