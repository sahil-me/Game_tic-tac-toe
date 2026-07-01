import controllers.GameController;
import exceptions.InvalidGameConstructionParametersException;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.HashSet;
import java.util.Set;

public class TicTacToeMain {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        GameController gameController = new GameController();

        while (true) {

            try {

                if (!playGame(in, gameController)) {

                    System.out.println("""                    
                                    =================================
                                          Thanks for Playing!
                                    =================================
                                    """);

                    break;
                }

            } catch (InvalidGameConstructionParametersException e) {

                System.out.println(e.getMessage());
            }
        }

        in.close();
    }

    private static boolean playGame(
                        Scanner in,
                        GameController gameController)
                        throws InvalidGameConstructionParametersException {

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
        String botChoice;

        while (true) {

            System.out.print("Will there be a bot in the game? (y/n): ");

            botChoice = in.next();

            if (botChoice.equalsIgnoreCase("y") ||
                    botChoice.equalsIgnoreCase("n")) {
                break;
            }

            System.out.println("Invalid input. Please enter only y or n.");
        }

        List<Player> players = new ArrayList<>();

        Set<String> playerNames = new HashSet<>();
        Set<Character> playerSymbols = new HashSet<>();

        int toIterate = size - 1;

        if (botChoice.equalsIgnoreCase("y")) {
            toIterate--;
        }

        for (int i = 1; i <= toIterate; i++) {

            // Player Name
            String playerName;

            while (true) {

                System.out.println("What is the name of player " + i + "?");
                playerName = in.next();

                String normalizedName = playerName.toLowerCase();

                if (playerNames.contains(normalizedName)) {
                    System.out.println("This name is already taken. Try another name!");
                    continue;
                }

                playerNames.add(normalizedName);
                break;
            }

            // Player Symbol
            char playerSymbol;

            while (true) {

                System.out.println("What is the symbol for player " + i + "?");
                playerSymbol = Character.toUpperCase(in.next().charAt(0));

                if (playerSymbols.contains(playerSymbol)) {
                    System.out.println("This symbol is already taken. Choose a unique symbol!");
                    continue;
                }

                playerSymbols.add(playerSymbol);
                break;
            }

            players.add(new Player(playerName, playerSymbol, PlayerType.HUMAN));
        }

        if (botChoice.equalsIgnoreCase("y")) {

            // Bot Name
            String botName;

            while (true) {

                System.out.println("What is the name of the bot?");
                botName = in.next();

                String normalizedBotName = botName.toLowerCase();

                if (playerNames.contains(normalizedBotName)) {
                    System.out.println("This name is already taken. Try another name!");
                    continue;
                }

                playerNames.add(normalizedBotName);
                break;
            }

            // Bot Symbol
            char botSymbol;

            while (true) {

                System.out.println("What is the symbol for the bot?");
                botSymbol = Character.toUpperCase(in.next().charAt(0));

                if (playerSymbols.contains(botSymbol)) {
                    System.out.println("This symbol is already taken. Choose a unique symbol!");
                    continue;
                }

                playerSymbols.add(botSymbol);
                break;
            }

            int choice;

            while (true) {

                System.out.println("""
                        Choose Bot Difficulty:
                        1 -> EASY
                        2 -> MEDIUM
                        3 -> HARD
                        """);

                if (!in.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    in.next();
                    continue;
                }

                choice = in.nextInt();

                if (choice >= 1 && choice <= 3) {
                    break;
                }

                System.out.println("Please choose 1, 2 or 3.");
            }

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
                    throw new IllegalStateException(
                            "Unexpected bot difficulty: " + choice);
            }

            players.add(new Bot(botName, botSymbol, level));
        }

        WinningStrategyType winningStrategy =
                WinningStrategyType.ORDER_ONE;

        Game game = gameController.createGame(
                size,
                players,
                winningStrategy
        );

        while (gameController.getGameState(game) == GameState.IN_PROGRESS) {

            System.out.println("\nThis is your current board");
            gameController.displayBoard(game);
            gameController.executeGame(game);
        }

        System.out.println("""
                \n
                =================================
                          GAME OVER
                =================================
                """);

        if (game.getGameState() == GameState.DRAW) {

            System.out.println("Result:\n🤝 It's a DRAW!");

        } else {

            System.out.println("\nResult:\n👑 Winner : "
                    + gameController.getWinner(game).getName());

            gameController.displayBoard(game);
        }

        String playAgain;

        while (true) {

            System.out.print("\nWould you like to play again? (y/n): ");

            playAgain = in.next();

            if (playAgain.equalsIgnoreCase("y") ||
                    playAgain.equalsIgnoreCase("n")) {
                break;
            }

            System.out.println("Please enter only y or n.");
        }

        return playAgain.equalsIgnoreCase("y");
    }
}
