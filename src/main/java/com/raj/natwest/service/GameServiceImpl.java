package com.raj.natwest.service;

import com.raj.natwest.NatwestApplication;
import com.raj.natwest.enums.Moves;
import com.raj.natwest.enums.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    //constructor
    public GameServiceImpl() {
    }

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Result getResult(Moves playerMove) {

        logger.info("getResult() method called with parameter playerMove = " + playerMove.toString());

        try {

            Moves computerMove = getRandomMove();
            logger.debug("computerMove = " + computerMove.toString());

            Result result = null;

            if (computerMove.equals(Moves.paper)) {
                if (playerMove.equals(Moves.rock)) {
                    result = Result.computer_win;
                } else if (playerMove.equals(Moves.paper)) {
                    result = Result.tie;
                } else {
                    result = Result.player_win;
                }
            } else if (computerMove.equals(Moves.rock)) {
                if (playerMove.equals(Moves.rock)) {
                    result = Result.tie;
                } else if (playerMove.equals(Moves.paper)) {
                    result = Result.player_win;
                } else {
                    result = Result.computer_win;
                }
            } else if (computerMove.equals(Moves.scissors)) {
                if (playerMove.equals(Moves.rock)) {
                    result = Result.player_win;
                } else if (playerMove.equals(Moves.paper)) {
                    result = Result.computer_win;
                } else {
                    result = Result.tie;
                }
            }

            logger.debug("result = " + result.toString());

            if (result == null) {
                logger.error("result is null");
            }

            return result;

        } catch (Exception e) {
            logger.error(e.toString());
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
            logger.debug("random index = " + rnd);

            return movesList.get(rnd);

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }
}
