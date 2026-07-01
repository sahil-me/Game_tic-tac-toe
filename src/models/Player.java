package models;

import java.util.Scanner;

public class Player {
    private final String name;
    private final char symbol;
    private final PlayerType playerType;

    private static final Scanner SCANNER = new Scanner(System.in);

    public Player(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public char getSymbol() {
        return symbol;
    }

//    public void setSymbol(char symbol) {
//        this.symbol = symbol;
//    }

    public PlayerType getPlayerType() {
        return playerType;
    }

//    public void setPlayerType(PlayerType playerType) {
//        this.playerType = playerType;
//    }

    public Move decideMove(Board board) {

        // ROW
        System.out.print("Enter row (0-" + (board.getSize() - 1) + "): ");

        while (!SCANNER.hasNextInt()) {
            System.out.println("Please enter a valid row!");
            SCANNER.next();
        }
        int row = SCANNER.nextInt();

        // Column
        System.out.print("Enter column (0-" + (board.getSize() - 1) + "): ");

        while (!SCANNER.hasNextInt()) {
            System.out.println("Please enter a valid column!");
            SCANNER.next();
        }
        int col = SCANNER.nextInt();

        if (row < 0 || row >= board.getSize()
                || col < 0 || col >= board.getSize()) {

            System.out.println("Invalid position.");

            return null;
        }

        Cell currentCell = board.getBoard().get(row).get(col);

        return new Move(this, currentCell);
    }
}

