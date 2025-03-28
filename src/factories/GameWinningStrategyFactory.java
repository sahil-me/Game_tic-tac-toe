package factories;

import strategies.gamewinningstrategy.GameWinningStrategy;
import strategies.gamewinningstrategy.OrderOneGameWinningStrategy;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getGameWinningStrategy(String winningStrategy, int size){
        if(winningStrategy.equals("OrderOne")){
            return new OrderOneGameWinningStrategy(size);
        }
        return null;
    }
}
