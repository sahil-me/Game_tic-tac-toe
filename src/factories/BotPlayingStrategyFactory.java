package factories;

import models.BotDifficultyLevel;
import strategies.botplayingstrategy.BotPlayingStrategy;
import strategies.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(BotDifficultyLevel difficultyLevel){

        switch (difficultyLevel) {

            case EASY:
                return new RandomBotPlayingStrategy();

            case MEDIUM:
                return new RandomBotPlayingStrategy();

            case HARD:
                return new RandomBotPlayingStrategy();

            default:
                throw new IllegalArgumentException(
                        "Unsupported bot difficulty: " + difficultyLevel);
        }
    }
}
