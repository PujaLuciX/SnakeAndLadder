import models.Ladder;
import models.Player;
import models.Snake;
import services.GameService.GameServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfSnakes, noOfLadders, noOfPlayers, sizeOfBoard = 100, noOfDice;

        System.out.println("Enter the size of the board: ");
        sizeOfBoard = scanner.nextInt();

        System.out.println("Enter the number of Dice you would like to have: ");
        noOfDice = scanner.nextInt();

        System.out.println("Enter the custom input of snake, ladder and player: ");

        noOfSnakes = scanner.nextInt();
        ArrayList<Snake> snakes = new ArrayList();
        for(int i = 0; i < noOfSnakes; i++) {
            int head = scanner.nextInt(), tail = scanner.nextInt();
            snakes.add(new Snake(head, tail));
        }

        noOfLadders = scanner.nextInt();
        ArrayList<Ladder> ladders = new ArrayList();
        for(int i = 0; i < noOfLadders; i++) {
            int start = scanner.nextInt(), end = scanner.nextInt();
            ladders.add(new Ladder(start, end));
        }

        noOfPlayers = scanner.nextInt();
        ArrayList<Player> players = new ArrayList();
        for(int i = 0; i < noOfPlayers; i++) {
            String playerName = scanner.next();
            players.add(new Player(playerName, i+1));
        }

        GameServiceImpl gameService = new GameServiceImpl();
        gameService.setPlayers(players);
        gameService.setBoard(sizeOfBoard, snakes, ladders);
        gameService.setDice(noOfDice);
        gameService.startGame();

        scanner.close();
    }
}
