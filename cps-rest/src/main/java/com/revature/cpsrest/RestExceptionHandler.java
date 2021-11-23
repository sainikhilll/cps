package com.revature.cpsrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.revature.cpsrest.exception.InvalidCredentialException;



@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseBody> handleException(Exception ex) {
    	if(ex instanceof InvalidCredentialException) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    	}
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
   
}