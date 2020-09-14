package com.demo.socialdata.exception;
/**
 * @author bariskantar
 */

public class NotFoundException  extends RuntimeException{
    public NotFoundException(String msg){
        super(msg);
    }
}
