package factories;

import models.WinningStrategyType;
import strategies.gamewinningstrategy.GameWinningStrategy;
import strategies.gamewinningstrategy.OrderOneGameWinningStrategy;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getGameWinningStrategy(
            WinningStrategyType winningStrategy,
            int size){

        switch (winningStrategy) {

            case ORDER_ONE:
                return new OrderOneGameWinningStrategy(size);

            default:
                throw new IllegalArgumentException(
                        "Unsupported winning strategy: " + winningStrategy);
        }
    }
}
