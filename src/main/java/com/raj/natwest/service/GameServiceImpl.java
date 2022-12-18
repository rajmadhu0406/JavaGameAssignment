package com.raj.natwest.service;

import com.raj.natwest.Exceptions.InvalidMoveException;
import com.raj.natwest.Exceptions.NullParameterException;
import com.raj.natwest.enums.Moves;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    //constructor
    public GameServiceImpl() {}

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getResult(String player, Moves computerMove)  {

        String result = null;

        //handling empty or null string parameter
        if(player == "" || player == null)
        {
            throw new NullParameterException("Request parameter can not be null");
        }

        try {

            //player move
            Moves playerMove = Moves.valueOf(player.toLowerCase());

            logger.debug("playerMove = " + playerMove.toString());


            logger.debug("computerMove = " + computerMove.toString());


            //game logic
            if (computerMove.equals(Moves.paper)) {
                if (playerMove.equals(Moves.rock)) {
                    result = "Computer wins";
                } else if (playerMove.equals(Moves.paper)) {
                    result = "It is a tie";
                } else {
                    result = "Player wins";
                }
            } else if (computerMove.equals(Moves.rock)) {
                if (playerMove.equals(Moves.rock)) {
                    result = "It is a tie";
                } else if (playerMove.equals(Moves.paper)) {
                    result = "Player wins";
                } else {
                    result = "Computer wins";
                }
            } else if (computerMove.equals(Moves.scissors)) {
                if (playerMove.equals(Moves.rock)) {
                    result = "Player wins";
                } else if (playerMove.equals(Moves.paper)) {
                    result = "Computer wins";
                } else {
                    result = "It is a tie";
                }
            }

        }
        catch (IllegalArgumentException illegalArgumentException) {
            logger.error(illegalArgumentException.getMessage());
            throw new InvalidMoveException("Invalid Move! You can only select Rock, Paper or Scissors");
        }catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }

        logger.debug("result = " + result);

        return result;
    }

    @Override
    public Moves getRandomMove() {

        logger.info("getRandomMove() method called...");

        try {
            List<Moves> movesList = new ArrayList<Moves>();

            movesList.add(Moves.rock);
            movesList.add(Moves.paper);
            movesList.add(Moves.scissors);

            //get random integer from between 0 (including) and movesList size (excluding)
            int rnd = new Random().nextInt(movesList.size());

            //get movesList element based on index 'rnd'
            return movesList.get(rnd);

        } catch (Exception e) {
            throw e;
        }
    }
}
