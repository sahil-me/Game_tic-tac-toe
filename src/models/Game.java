package models;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextPlayerIndex;
    private Player winner;
    private List<Move> moves;
}
