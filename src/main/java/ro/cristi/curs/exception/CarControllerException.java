package ro.cristi.curs.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CarControllerException extends RuntimeException{
    
    private Integer errorCode;

    public CarControllerException(Integer errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
