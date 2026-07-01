package strategies.botplayingstrategy;

import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move decideMove(Player player, Board board) {

        List<Cell> emptyCells = new ArrayList<>();

        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){

                if (board.getBoard().get(i).get(j).getCellState() == CellState.EMPTY) {
                    emptyCells.add(board.getBoard().get(i).get(j));
                }
            }
        }

        if (emptyCells.isEmpty()) {
            return null;
        }

        Random random = new Random();

        Cell randomCell = emptyCells.get(random.nextInt(emptyCells.size()));

        return new Move(player, randomCell);
    }
}
