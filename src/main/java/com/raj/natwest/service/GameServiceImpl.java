package com.raj.natwest.service;

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
    public String getResult(Moves playerMove) {

        logger.debug("parameter playerMove = " + playerMove.toString());

        try {

            Moves computerMove = getRandomMove();
            logger.debug("computerMove = " + computerMove.toString());

            String result = null;

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

            logger.debug("result = " + result);

            return result;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Moves getRandomMove() {

        logger.info("getRandomMove() method called...");

        try {
            List<Moves> movesList = new ArrayList<Moves>();

            movesList.add(Moves.rock);
            movesList.add(Moves.paper);
            movesList.add(Moves.scissors);

            int rnd = new Random().nextInt(movesList.size());

            return movesList.get(rnd);

        } catch (Exception e) {
            throw e;
        }
    }
}
