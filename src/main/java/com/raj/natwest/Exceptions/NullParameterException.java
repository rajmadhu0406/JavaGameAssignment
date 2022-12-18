package com.raj.natwest.Exceptions;

public class NullParameterException extends RuntimeException{
    public NullParameterException(String errorMessage){
        super(errorMessage);
    }
}
