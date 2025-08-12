package donjons_et_dragons.board;

import java.util.Random;

//class pour initialiser et donner les dée
public class Dice {
    private int diceNumber;
    private Random rand = new Random();
    private int actionDiceNumber;


    public Dice() {
        this.diceNumber = rand.nextInt(6) + 1;
        this.actionDiceNumber = rand.nextInt(20) + 1;
    }

    public int getDiceNumber() { return this.diceNumber; }
    public void setDiceNumber(int diceNumber) { this.diceNumber = diceNumber; }

    public Random getRand() {return rand; }
    public void setRand(Random rand) {this.rand = rand; }




    public int getActionDiceNumber() {
        return actionDiceNumber;
    }public void setActionDiceNumber(int actionDiceNumber) {
        this.actionDiceNumber = actionDiceNumber;
    }


    // lance un dée de 20
    public void actionDice() {
        this.actionDiceNumber = rand.nextInt(20) + 1;
    }

    // lance un dée de 6
    public int sixdice() {
        this.diceNumber = rand.nextInt(6) + 1;
        return this.diceNumber;
    }
}