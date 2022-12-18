package com.raj.natwest.controller;

import com.raj.natwest.enums.Moves;
import com.raj.natwest.service.GameServiceImpl;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Get game result", notes = "Returns the result of the game based on the parameter 'playerMove'")
    @GetMapping("/play")
    public ResponseEntity<Object> getResponse(@RequestParam(value = "playerMove") String player) {

        Moves playerMove;

        //empty input handling
        if (player.equals("") || player == null) {
            logger.error("Player parameter is empty!");
            return new ResponseEntity<>("Player move empty!", HttpStatus.BAD_REQUEST);
        }

        //invalid input handling
        try {
            playerMove = Moves.valueOf(player.toLowerCase());
        } catch (Exception e) {
            logger.error("invalid playerMove!");
            return new ResponseEntity<>(e.getMessage() + " => Enter moves from Rock, Paper or Scissors only", HttpStatus.BAD_REQUEST);
        }


        //return result
        String result = gameService.getResult(playerMove);

        if(result == null)
        {
            return new ResponseEntity<>("Error in getting results!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }


    //example test API
    @GetMapping("/home")
    public ResponseEntity<Object> home() {
        return new ResponseEntity<>("home", HttpStatus.OK);
    }

}



