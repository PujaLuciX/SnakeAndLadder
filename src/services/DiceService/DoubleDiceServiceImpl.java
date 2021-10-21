package services.DiceService;

import java.util.Random;

public class DoubleDiceServiceImpl implements DiceServiceInterface{

    @Override
    public int rollDice() {
        Random dice1 = new Random();
        Random dice2 = new Random();
        return dice1.nextInt(6) + dice2.nextInt(6);
    }

}
