package com.raj.natwest.service;

import com.raj.natwest.enums.Moves;
import com.raj.natwest.enums.Result;

public interface GameService {

    /**
     * Get result of the game
     *
     * @param move by the player
     * @return result of the game
     *
     */
    Result getResult(Moves playerMove);

    /**
     * Generate random move out Rock, Paper or Scissors
     *
     * @return random move
     */
    Moves getRandomMove();

}
