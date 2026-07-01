import controllers.GameController;
import exceptions.InvalidGameConstructionParametersException;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GameController gameController = new GameController();
        System.out.println("\n=========== Welcome to Tic Tac Toe ============");

        // Dimension
        int size;

        while (true) {

            System.out.print("Enter board dimension (minimum 3): ");

            if (!in.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                in.next();      // discard invalid input
                continue;
            }

            size = in.nextInt();

            if (size >= 3) {
                break;
            }

            System.out.println("Board dimension must be at least 3.");
        }

        // BOT
        String isBotString;

        while (true) {

            System.out.print("Will there be a bot in the game? (y/n): ");

            isBotString = in.next();

            if (isBotString.equalsIgnoreCase("y") ||
                    isBotString.equalsIgnoreCase("n")) {
                break;
            }

            System.out.println("Invalid input. Please enter only y or n.");
        }

        List<Player> players = new ArrayList<>();

        int toIterate = size - 1;

        if (isBotString.equalsIgnoreCase("y")) {
            toIterate--;
        }

        for (int i = 1; i <= toIterate; i++) {

            System.out.println("What is the name of player " + i + "?");
            String playerName = in.next();

            System.out.println("What is the symbol for player " + i + "?");
            char playerSymbol = in.next().charAt(0);

            players.add(new Player(playerName, playerSymbol, PlayerType.HUMAN));
        }

        if (isBotString.equalsIgnoreCase("y")) {

            System.out.println("What is the name of the bot?");
            String botName = in.next();

            System.out.println("What is the symbol for the bot?");
            char botSymbol = in.next().charAt(0);

            System.out.println("""
                            Choose Bot Difficulty:
                            1. EASY
                            2. MEDIUM
                            3. HARD
                            """);

            int choice = in.nextInt();

            BotDifficultyLevel level;

            switch (choice) {
                case 1:
                    level = BotDifficultyLevel.EASY;
                    break;

                case 2:
                    level = BotDifficultyLevel.MEDIUM;
                    break;

                case 3:
                    level = BotDifficultyLevel.HARD;
                    break;

                default:
                    System.out.println("Invalid choice. Defaulting to EASY.");
                    level = BotDifficultyLevel.EASY;
            }

            players.add(new Bot(botName, botSymbol, level));
        }

        String winningStrategy = "OrderOne";

        Game game;

        try {
            game = gameController.createGame(
                    size,
                    players,
                    winningStrategy
            );
        } catch (InvalidGameConstructionParametersException e) {
            System.out.println(e.getMessage());
            return;
        }

        while(gameController.getGameState(game) == GameState.IN_PROGRESS) {
            System.out.println("\nThis is your current board");
            gameController.displayBoard(game);

            gameController.executeGame(game);
        }

        if(game.getGameState() == GameState.DRAW) {

            System.out.println("\nGame has ended!");
            System.out.println("Result:\nIt's a DRAW! 🤝");
        }

        if(game.getGameState() != GameState.DRAW){

            System.out.println("\nGame has ended!");
            System.out.println("\nResult:\nWinner is " + gameController.getWinner(game).getName() + " 👑");
            gameController.displayBoard(game);
        }

    }
}
