package com.raj.natwest.ExceptionHandler;

import com.raj.natwest.CustomExceptions.InvalidMoveException;
import com.raj.natwest.CustomExceptions.NullParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GameControllerAdvice {

    /** Handle null player move */
    @ExceptionHandler(NullParameterException.class)
    public ResponseEntity<String> MissingParameterHandler(NullParameterException nullParameterException){
        return new ResponseEntity<>("request parameter can not be null or empty!", HttpStatus.BAD_REQUEST);
    }

    /** Handle invalid player move */
    @ExceptionHandler(InvalidMoveException.class)
    public ResponseEntity<String> InvalidMoveHandler(InvalidMoveException invalidMoveException){
        return new ResponseEntity<String >("Invalid Move! You can only select Rock, Paper or Scissors!", HttpStatus.BAD_REQUEST);
    }

}
