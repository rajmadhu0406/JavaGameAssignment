package com.raj.natwest.CustomExceptions;


/** Custom exception for Invalid player move */
public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String errorMessage){
        super(errorMessage);
    }
}
