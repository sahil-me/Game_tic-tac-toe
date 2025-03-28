package models;

import factories.BotPlayingStrategyFactory;
import strategies.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.Bot);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficultyLevel(botDifficultyLevel);
    }

    public Move decideMove(Board board){
        return botPlayingStrategy.decideMove(this, board);
    }
}
