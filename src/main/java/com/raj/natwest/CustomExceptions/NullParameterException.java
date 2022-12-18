package com.raj.natwest.CustomExceptions;


/** Custom exception for null player move */
public class NullParameterException extends RuntimeException{
    public NullParameterException(String errorMessage){
        super(errorMessage);
    }
}
