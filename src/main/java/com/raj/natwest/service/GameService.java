package com.raj.natwest.service;

import com.raj.natwest.enums.Moves;
import com.raj.natwest.enums.Result;

public interface GameService {

    //return the result of the game
    Result getResult(Moves playerMove);

    //generates a random move
    Moves getRandomMove();

}
