package com.raj.natwest.service;

import com.raj.natwest.CustomExceptions.NullParameterException;
import com.raj.natwest.enums.Moves;

public interface GameService {

    /**
     * Get result of the game
     *
     * @param player move, computer move
     * @return result of the game
     *
     */
    String getResult(String player, Moves computerMove) throws NullParameterException, Exception;



    /**
     * Generate random move out of Rock, Paper or Scissors
     *
     * @return random move
     */
    Moves getRandomMove();

}
