package ro.cristi.curs.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CarServiceException extends RuntimeException{
    
    private Integer errorCode;

    public CarServiceException(Integer errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
