package models;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreBoard {

    private final Map<String, Integer> wins = new LinkedHashMap<>();
    private int draws;

    public void recordWin(String playerName) {

        wins.put(playerName,
                wins.getOrDefault(playerName, 0) + 1);
    }

    public void recordDraw() {
        draws++;
    }

    public void display() {

        System.out.println("""
                
                =================================
                     SCOREBOARD
                =================================
                """);

        for (Map.Entry<String, Integer> entry : wins.entrySet()) {

            System.out.println(entry.getKey()
                    + " Wins : " + entry.getValue());
        }

        System.out.println("Draws : " + draws);

        System.out.println("=================================");
    }

}
