package services.GameService;

import models.Ladder;
import models.Player;
import models.Snake;

import java.util.ArrayList;

public interface GameServiceInterface {

    public void setPlayers(ArrayList<Player> players);

    public void setBoard(int size, ArrayList<Snake> snakes, ArrayList<Ladder> ladders);

    public void setDice(int noOfDice);

    public void startGame();

}
