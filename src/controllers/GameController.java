package controllers;

import exceptions.InvalidGameConstructionParametersException;
import models.Board;
import models.Game;
import models.GameState;
import models.Player;

import java.util.List;

public class GameController {

    public Game createGame(int size,
                           List<Player> players,
                           String winningStrategy)
            throws InvalidGameConstructionParametersException {

        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setGameWinningStrategy(winningStrategy)
                .build();
    }

    public void displayBoard(Game game){

        game.displayBoard();
    }

    public GameState getGameState(Game game){

        return game.getGameState();
    }

    public void executeGame(Game game){

        game.makeNextMove();
    }

    public Player getWinner(Game game) {

        return game.getWinner();
    }
}
