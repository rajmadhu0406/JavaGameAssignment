package com.raj.natwest.ExceptionHandler;

import com.raj.natwest.Exceptions.InvalidMoveException;
import com.raj.natwest.Exceptions.NullParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GameControllerAdvice {

    @ExceptionHandler(NullParameterException.class)
    public ResponseEntity<String> MissingParameterHandler(NullParameterException nullParameterException){
        return new ResponseEntity<String>("Request parameter can not be left empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidMoveException.class)
    public ResponseEntity<String> InvalidMoveHandler(InvalidMoveException invalidMoveException){
        return new ResponseEntity<String >("Invalid Move! You can only select Rock, Paper or Scissors!", HttpStatus.BAD_REQUEST);
    }




}
