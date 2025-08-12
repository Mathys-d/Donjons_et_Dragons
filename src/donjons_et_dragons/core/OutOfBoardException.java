package donjons_et_dragons.core;

/**
 * Exception levée lorsqu'une position est hors du plateau.
 */
public class OutOfBoardException extends Exception {
    /**
     * Constructeur avec message d'erreur.
     *
     * @param message message de l'exception
     */
    public OutOfBoardException(String message) {
        super(message);
    }
}
