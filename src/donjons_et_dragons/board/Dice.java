package donjons_et_dragons.board;

import java.util.Random;

/**
 * class pour initialiser et donner les dée
 */
public class Dice {
    private int diceNumber;
    private Random rand = new Random();
    private int actionDiceNumber;


    /**
     * constructor de déé
     */
    public Dice() {
        this.diceNumber = rand.nextInt(6) + 1;
        this.actionDiceNumber = rand.nextInt(20) + 1;
    }

    /**
     * retourne les nombre donné par les dée
     * @return
     */
    public int getDiceNumber() { return this.diceNumber; }

    /**
     * actualise le nombre donné par les dée
     * @param diceNumber
     */
    public void setDiceNumber(int diceNumber) { this.diceNumber = diceNumber; }


    /**
     * retourne le nombre aleatoire
     * @return
     */
    public Random getRand() {return rand; }

    /**
     * actualise le nomre aleaiore
     * @param rand
     */
    public void setRand(Random rand) {this.rand = rand; }


    /**
     * set le nomre
     * et donne le nombre
     * @return
     */
    public int getActionDiceNumber() {
        return actionDiceNumber;
    }public void setActionDiceNumber(int actionDiceNumber) {
        this.actionDiceNumber = actionDiceNumber;
    }


    /**
     *  lance un dée de 20
     */
    public void actionDice() {
        this.actionDiceNumber = rand.nextInt(20) + 1;
    }

    /**
     * lance un dée de 6
     * @return
     */
    public int sixdice() {
        this.diceNumber = rand.nextInt(6) + 1;
        return this.diceNumber;
    }
}