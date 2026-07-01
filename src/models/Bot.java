package models;

import factories.BotPlayingStrategyFactory;
import strategies.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player {

    private final BotDifficultyLevel botDifficultyLevel;
    private final BotPlayingStrategy botPlayingStrategy;

    public Bot(String name,
               char symbol,
               BotDifficultyLevel botDifficultyLevel) {

        super(name, symbol, PlayerType.BOT);

        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy =
                BotPlayingStrategyFactory
                        .getBotPlayingStrategyByDifficultyLevel(botDifficultyLevel);
    }

    @Override
    public Move decideMove(Board board){

        return botPlayingStrategy.decideMove(this, board);
    }
}
