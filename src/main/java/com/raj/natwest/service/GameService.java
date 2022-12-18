package com.raj.natwest.service;

import com.raj.natwest.Exceptions.NullParameterException;
import com.raj.natwest.enums.Moves;

public interface GameService {

    /**
     * Get result of the game
     *
     * @param move by the player
     * @return result of the game
     *
     */
    String getResult(String player, Moves computerMove) throws NullParameterException, Exception;

    /**
     * Generate random move out Rock, Paper or Scissors
     *
     * @return random move
     */
    Moves getRandomMove();

}
