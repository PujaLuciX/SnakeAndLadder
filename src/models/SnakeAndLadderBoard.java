package models;

import java.util.ArrayList;

public class SnakeAndLadderBoard {
    private int size;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;

    public SnakeAndLadderBoard(int size, ArrayList<Snake> snakes, ArrayList<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public int getSnake(int position) {
        for(int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getHead() == position)
                return snakes.get(i).getTail();
        }
        return position;
    }

    public int getLadder(int position) {
        for(int i = 0; i < ladders.size(); i++) {
            if (ladders.get(i).getStart() == position)
                return ladders.get(i).getEnd();
        }
        return position;
    }

}
