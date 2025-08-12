package donjons_et_dragons.board;

import java.util.Random;

/**
 * Classe pour initialiser et gérer les dés.
 */
public class Dice {
    private int diceNumber;
    private Random rand = new Random();
    private int actionDiceNumber;

    /**
     * Constructeur du dé.
     */
    public Dice() {
        this.diceNumber = rand.nextInt(6) + 1;
        this.actionDiceNumber = rand.nextInt(20) + 1;
    }

    /**
     * Retourne le nombre obtenu avec le dé à 6 faces.
     * @return valeur du dé
     */
    public int getDiceNumber() { return this.diceNumber; }

    /**
     * Définit le nombre du dé.
     * @param diceNumber valeur à définir
     */
    public void setDiceNumber(int diceNumber) { this.diceNumber = diceNumber; }

    /**
     * Retourne l'objet Random.
     * @return instance de Random
     */
    public Random getRand() {return rand; }

    /**
     * Définit l'objet Random.
     * @param rand instance de Random à définir
     */
    public void setRand(Random rand) {this.rand = rand; }

    /**
     * Retourne le nombre du dé d'action (20 faces).
     * @return valeur du dé d'action
     */
    public int getActionDiceNumber() {
        return actionDiceNumber;
    }

    /**
     * Définit le nombre du dé d'action.
     * @param actionDiceNumber valeur à définir
     */
    public void setActionDiceNumber(int actionDiceNumber) {
        this.actionDiceNumber = actionDiceNumber;
    }

    /**
     * Lance un dé d'action à 20 faces.
     */
    public void actionDice() {
        this.actionDiceNumber = rand.nextInt(20) + 1;
    }

    /**
     * Lance un dé à 6 faces et retourne la valeur.
     * @return valeur du dé à 6 faces
     */
    public int sixdice() {
        this.diceNumber = rand.nextInt(6) + 1;
        return this.diceNumber;
    }
}
