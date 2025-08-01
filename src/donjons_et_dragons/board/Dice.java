package donjons_et_dragons.board;

import java.util.Random;

public class Dice {
    private int diceNumber;
    private Random rand = new Random();

    public Dice() {
    }

    public int rollDice() {
        this.diceNumber = rand.nextInt(6) + 1;
        return this.diceNumber;
    }

    public int getDiceNumber() {
        return this.diceNumber;
    }
}
