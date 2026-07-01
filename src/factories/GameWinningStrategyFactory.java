package factories;

import strategies.gamewinningstrategy.GameWinningStrategy;
import strategies.gamewinningstrategy.OrderOneGameWinningStrategy;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getGameWinningStrategy(
            String winningStrategy,
            int size){

        switch (winningStrategy) {

            case "OrderOne":
                return new OrderOneGameWinningStrategy(size);

            default:
                throw new IllegalArgumentException(
                        "Unsupported winning strategy: " + winningStrategy);
        }
    }
}
