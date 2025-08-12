package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.board.Dice;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.db.MainDbConnexion;
import donjons_et_dragons.db.queryDb.editNameDbConnexion;
import donjons_et_dragons.ui.Menu;

import java.sql.SQLException;
import java.util.Scanner;
import donjons_et_dragons.character.ChoosCharacter;

/**
 * La classe {@code Commands} gère les commandes principales du jeu Donjons & Dragons.
 * <p>
 * Elle permet au joueur d'interagir avec le menu principal, de lancer une partie,
 * d'afficher les informations de son personnage, de modifier son nom, ou de quitter le jeu.
 * </p>
 *
 * <h2>Commandes disponibles :</h2>
 * <ul>
 *     <li><b>start</b> : Lance une nouvelle partie avec le personnage sélectionné.</li>
 *     <li><b>info</b> : Affiche les informations du personnage courant.</li>
 *     <li><b>edit</b> : Permet de modifier le nom d'un héros en base de données.</li>
 *     <li><b>quit</b> : Quitte le jeu après confirmation.</li>
 * </ul>
 *
 * @author
 * @version 1.0
 */
public class Commands {

    /** Interface du personnage courant. */
    protected Character interfaceCharacter;

    /** Plateau de jeu utilisé lors d'une partie. */
    protected Board board;

    /** Nombre de pas effectués sur le plateau. */
    protected int steps = 0;

    /** Dé utilisé pour avancer sur le plateau. */
    protected Dice dice = new Dice();

    /** Scanner pour la lecture des entrées utilisateur dans le menu principal. */
    Scanner clavier = new Scanner(System.in);

    /** Gestionnaire principal de la partie. */
    Game game = new Game();

    /** Connexion principale à la base de données. */
    MainDbConnexion connexion = new MainDbConnexion();

    /** Interface graphique texte du menu. */
    Menu interfaceMenu = new Menu();

    /** Gestion du choix du personnage. */
    ChoosCharacter chooseCharacter = new ChoosCharacter(interfaceMenu);

    /** Personnage actif contrôlé par le joueur. */
    protected Character player;

    /** Scanner secondaire pour la saisie utilisateur. */
    Scanner scanner = new Scanner(System.in);

    /** Accès à la fonctionnalité d'édition de nom dans la base de données. */
    editNameDbConnexion editName = new editNameDbConnexion();

    /**
     * Boucle principale de gestion des commandes du menu.
     * <p>
     * Cette méthode affiche un prompt demandant au joueur de saisir une commande,
     * puis exécute l'action correspondante :
     * </p>
     * <ul>
     *     <li><b>quit</b> : Demande confirmation et quitte le jeu si confirmé.</li>
     *     <li><b>info</b> : Affiche les informations du personnage courant.</li>
     *     <li><b>start</b> : Crée un nouveau plateau et lance la partie.</li>
     *     <li><b>edit</b> : Modifie le nom d'un héros dans la base.</li>
     *     <li>Autre : Affiche "unknown Command".</li>
     * </ul>
     *
     * @param player Le personnage contrôlé par le joueur.
     *
     * @throws RuntimeException si une erreur SQL survient lors du lancement de la partie.
     */
    public void commandMenu(Character player) {
        this.interfaceCharacter = player;
        while (true) {
            System.out.print("Command (start / info / edit / quit) : ");
            String input = clavier.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.print("Do you want to leave ? (yes/no) : ");
                String confirm = clavier.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    System.out.println("Game closed.");
                    break;
                }
            }
            if (input.equalsIgnoreCase("info")) {
                interfaceMenu.displayCharacter(interfaceCharacter);
            } else if (input.equalsIgnoreCase("start")) {
                try {
                    game.player = interfaceCharacter;
                    game.board = new Board(64);
                    game.start();
                } catch (OutOfBoardException e) {
                    System.out.println(e.getMessage());
                    System.out.println("You win");
                    interfaceCharacter.defPosition();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (input.equalsIgnoreCase("edit")) {
                String entree = clavier.nextLine();
                if (entree.isEmpty()) {
                    System.out.println("entree is empty.");
                } else {
                    System.out.print("which hero would you like to edit: ? ");
                    String changingName = scanner.nextLine().trim();
                    System.out.print("What would you like new name: ? ");
                    String newName = clavier.nextLine();
                    try {
                        editNameDbConnexion.editHero(changingName, newName);
                        player.setName(newName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println("unknown Command.");
            }
        }
    }
}
