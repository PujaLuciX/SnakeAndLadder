package models;

import java.util.List;
import java.util.Random;

public class Player {

    private String name;
    private int id;
    private List<Integer> gameId;
    private List<Integer> atPosition;
    private boolean hasWon;

    public Player(String name, int id) {
        this.name = name;
        //this.atPosition.add(0);
        this.hasWon = false;
        //this.gameId.add(random());
        this.id = id;
    }

    public int getPlayerId() {
        return id;
    }

    public String getPlayerName() {
        return name;
    }

    public int getPosition() {
        return atPosition;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setPosition(int position) {
        this.atPosition = position;
    }

    public void updateStatus(boolean hasWon) {
        this.hasWon = hasWon;
    }
}
