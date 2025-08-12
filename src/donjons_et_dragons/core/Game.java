package donjons_et_dragons.game;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.ui.Menu;

/**
 * Classe principale du jeu, qui gère la boucle et la logique.
 */
public class Game {
    private Board board;
    private Character player;
    private Menu menu;

    /**
     * Constructeur de jeu.
     *
     * @param board plateau de jeu
     * @param player personnage joueur
     * @param menu interface utilisateur
     */
    public Game(Board board, Character player, Menu menu) {
        this.board = board;
        this.player = player;
        this.menu = menu;
    }

    /**
     * Démarre la boucle principale du jeu.
     */
    public void start() {
        // logique du jeu
    }

    // Autres méthodes de gestion du jeu
}
