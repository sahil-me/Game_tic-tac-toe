package models;

import exceptions.InvalidGameConstructionParametersException;
import factories.GameWinningStrategyFactory;
import strategies.gamewinningstrategy.GameWinningStrategy;

import java.util.HashSet;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextPlayerIndex;

    private Player winner;
    private List<Move> moves;

    private GameWinningStrategy gameWinningStrategy;

    private Game(){

    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void displayBoard() {
        this.board.display();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public void makeNextMove() {

        // I am picking the player whose turn it is to move
        Player toMovePlayer = players.get(nextPlayerIndex);

        System.out.println("It is " + toMovePlayer.getName() + "'s turn");

        // validate the move
        Move move = toMovePlayer.decideMove(board);

        if (!validateCurrentMove(move)) {
            System.out.println("Invalid move! Try again.");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        System.out.println("Move happened at: " + row + ", " + col);

        // update the board
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        // updated my list of moves in this game
        moves.add(move);

        // Check the winner
        if(this.gameWinningStrategy.checkWinner(board, move.getCell(), toMovePlayer)){
            gameState = GameState.ENDED;
            winner = toMovePlayer;
            return;
        }

        // Draw
        if (moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
            return;
        }

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

    }

    private boolean validateCurrentMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        return row >= 0 && row < board.getSize() &&
                col >= 0 && col < board.getSize() &&
                move.getCell().getCellState() == CellState.EMPTY;
    }

    public static class Builder {
        private int size;
        private List<Player> players;

        private GameWinningStrategy gameWinningStrategy;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setGameWinningStrategy(String winningStrategy) {
            this.gameWinningStrategy = GameWinningStrategyFactory.getGameWinningStrategy(winningStrategy, this.size);
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validate() throws InvalidGameConstructionParametersException {

            if (this.size < 3) {
                throw new InvalidGameConstructionParametersException(
                        "The size of the board cannot be less than 3");
            }

            if (this.players == null || this.players.isEmpty()) {
                throw new InvalidGameConstructionParametersException(
                        "Players list cannot be empty");
            }

            if (this.players.size() != size - 1) {
                throw new InvalidGameConstructionParametersException(
                        "The number of players in the game should be board size - 1");
            }

            if (this.gameWinningStrategy == null) {
                throw new InvalidGameConstructionParametersException(
                        "Invalid game winning strategy");
            }

            Set<String> playerNames = new HashSet<>();
            Set<Character> playerSymbols = new HashSet<>();

            for (Player player : players) {

                if (!playerNames.add(player.getName())) {
                    throw new InvalidGameConstructionParametersException(
                            "Duplicate player names are not allowed");
                }

                if (!playerSymbols.add(player.getSymbol())) {
                    throw new InvalidGameConstructionParametersException(
                            "Duplicate player symbols are not allowed");
                }
            }
        }

        public Game build() throws InvalidGameConstructionParametersException {

            // validations
            validate();

            Game game = new Game();
            game.setGameState(GameState.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setBoard(new Board(size));
            game.setPlayers(players);
            game.setGameWinningStrategy(this.gameWinningStrategy);

            return game;
        }
    }
}
