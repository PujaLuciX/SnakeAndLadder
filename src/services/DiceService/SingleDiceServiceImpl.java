package services.DiceService;

import java.util.Random;

public class SingleDiceServiceImpl implements DiceServiceInterface {

    @Override
    public int rollDice() {
        Random dice = new Random();
        return dice.nextInt(6);
    }

}
