package com.demo.socialdata.exception;
/**
 * @author bariskantar
 */

import com.demo.socialdata.model.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity ex(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse("Internal Server Error ",null));
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity ex(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse(ex.getMessage(),null));
    }
}
