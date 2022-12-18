package com.raj.natwest.controller;

import com.raj.natwest.Exceptions.InvalidMoveException;
import com.raj.natwest.Exceptions.NullParameterException;
import com.raj.natwest.enums.Moves;
import com.raj.natwest.service.GameServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class gameController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GameServiceImpl gameService;


    @ApiOperation(value = "Get game result", notes = "Returns the result of the game based on the user parameter 'playerMove' and randomly generated 'computerMove'.\n\n\n"+"Accepted player moves are 'Rock', 'Paper' and 'Scissors'.\n\n\n"+"Return result can be 'Computer wins', 'Player wins' or 'It is a tie'.\n", response = String.class) //Swagger description

    @GetMapping("/play")
    public ResponseEntity<Object> getResponse(@RequestParam(value = "playerMove") String playerInput) {

        logger.debug("String player : " + playerInput);

        //get random computer move
        Moves computerMove = gameService.getRandomMove();

        String result = gameService.getResult(playerInput, computerMove);
        return  new ResponseEntity<>(result, HttpStatus.OK);

        //http://localhost:8081/game/play?playerMove=Rock
    }


    //example test API
    @GetMapping("/home")
    public ResponseEntity<Object> home() {
        return new ResponseEntity<>("home", HttpStatus.OK);
    }

}



