package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        /*
        [cell(0,0), cell(0,1), cell(0,2)],
        [cell(1,0), cell(1,1), cell(1,2)],
        [cell(2,0), cell(2,1), cell(2,2)],
         */
        for(int i=0; i<size; i++) {
            this.board.add(new ArrayList<>());
            for(int j=0; j<size; j++) {
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getSize() {

        return size;
    }

    public List<List<Cell>> getBoard() {

        return board;
    }

    public void display() {

        String separator = "-".repeat(size * 4 + 1);

        for (int i = 0; i < size; i++) {

            System.out.println(separator);

            for (int j = 0; j < size; j++) {

                Cell cell = board.get(i).get(j);

                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("|   ");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol() + " ");
                }
            }

            System.out.println("|");
        }

        System.out.println(separator);
    }
}
