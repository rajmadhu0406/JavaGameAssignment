package com.raj.natwest.Exceptions;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String errorMessage){
        super(errorMessage);
    }
}
