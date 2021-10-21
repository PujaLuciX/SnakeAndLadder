package services.GameService;

import factory.DiceFactory;
import models.Ladder;
import models.Player;
import models.Snake;
import models.SnakeAndLadderBoard;
import org.jetbrains.annotations.NotNull;
import services.DiceService.DiceServiceInterface;
import services.DiceService.DoubleDiceServiceImpl;
import services.DiceService.SingleDiceServiceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameServiceImpl implements GameServiceInterface{

    private int noOfPlayers, gameId;
    private Queue<Player> players = new LinkedList<>();
    private SnakeAndLadderBoard board;
    private int noOfDice;
    private DiceServiceInterface diceService;

    @Override
    public void setPlayers(ArrayList<Player> players) {
        this.noOfPlayers = players.size();
        for(Player player: players) {
            player.//game id and position
            this.players.add(player);

        }
    }

    @Override
    public void setBoard(int size, ArrayList<Snake> snakes, ArrayList<Ladder> ladders) {
        this.board = new SnakeAndLadderBoard(size, snakes, ladders);
    }

    @Override
    public void setDice(int noOfDice) {
        this.noOfDice = noOfDice;
        //diceService = DiceFactory.getDice(noOfDice);
        if(noOfDice == 1)
            diceService = new SingleDiceServiceImpl();
        else
            diceService = new DoubleDiceServiceImpl();
    }

    private int getNumber() {
        int diceValue1 = diceService.rollDice();
        if (diceValue1 == 6) {
            int diceValue2 = diceService.rollDice();
            if (diceValue2 == 6) {
                int diceValue3 = diceService.rollDice();
                if (diceValue3 == 6)
                    return 0;
                else
                    return diceValue1 + diceValue2 + diceValue3;
            }
            else
                return diceValue1 + diceValue2;
        }
        else
            return diceValue1;
    }

    private void movePlayer(@NotNull Player player, int diceValue) {
        int oldPosition = player.getPosition();
        int newPosition = oldPosition + diceValue;
        if (newPosition > board.getSize())
            return;
        else if (newPosition < board.getSize()) {
            int snakeTailPosition = board.getSnake(newPosition);
            int ladderEndPosition = board.getLadder(newPosition);
            if (snakeTailPosition != newPosition)
                newPosition = snakeTailPosition;
            else if (ladderEndPosition != newPosition)
                newPosition = ladderEndPosition;
        } else if (newPosition == board.getSize())
            player.updateStatus(true);
        player.setPosition(newPosition);
        System.out.println(player.getPlayerName() + " rolled a " + diceValue + " and moved from " + oldPosition + " to " +newPosition);
        return;
    }

    @Override
    public void startGame() {
        while(players.size() > 1) {
            int diceValue = getNumber();
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, diceValue);
            if (currentPlayer.isHasWon()) {
                System.out.println(currentPlayer.getPlayerName() + " wins the game !!");
            } else {
                players.add(currentPlayer);
            }
        }
    }
}
