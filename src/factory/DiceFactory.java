package factory;

import services.DiceService.DiceServiceInterface;
import services.DiceService.DoubleDiceServiceImpl;
import services.DiceService.SingleDiceServiceImpl;

public class DiceFactory {

    static DiceServiceInterface diceService;

    public static DiceServiceInterface getDice(int noOfDice) {
        if(noOfDice == 1)
            diceService = new SingleDiceServiceImpl();
        else
            diceService = new DoubleDiceServiceImpl();
        return null;
    }
}
