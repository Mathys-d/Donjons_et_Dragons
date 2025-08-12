package donjons_et_dragons.core;

import donjons_et_dragons.character.Character;
import donjons_et_dragons.character.ChoosCharacter;
import donjons_et_dragons.db.MainDbConnexion;
import donjons_et_dragons.db.queryDb.insertHeroDbConnexion;
import donjons_et_dragons.ui.Menu;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * La classe {@code LaunchGame} est le point d'entrée pour démarrer une partie de Donjons & Dragons.
 * <p>
 * Elle permet au joueur de :
 * <ul>
 *     <li>Sélectionner un personnage via {@link ChoosCharacter}</li>
 *     <li>Enregistrer ce personnage dans la base de données</li>
 *     <li>Accéder au menu principal géré par {@link Commands}</li>
 * </ul>
 * </p>
 *
 * <p>
 * Cette classe gère la configuration initiale de la partie et le lancement
 * de la boucle de commandes.
 * </p>
 *
 * @author
 * @version 1.0
 */
public class LaunchGame {

    /** Scanner utilisé pour la lecture des entrées utilisateur. */
    Scanner clavier = new Scanner(System.in);

    /** Interface console pour l'affichage du menu. */
    Menu interfaceMenu = new Menu();

    /** Gestionnaire de sélection de personnage. */
    ChoosCharacter chooseCharacter = new ChoosCharacter(interfaceMenu);

    /** Gestionnaire des commandes de jeu. */
    Commands commands = new Commands();

    /** Personnage actuellement sélectionné par le joueur. */
    protected Character player;

    /** Connexion principale à la base de données. */
    MainDbConnexion connexion = new MainDbConnexion();

    /** Interface pour l'insertion d'un héros dans la base de données. */
    insertHeroDbConnexion insertHeroDb = new insertHeroDbConnexion();

    /**
     * Méthode principale de lancement de la partie.
     * <p>
     * Elle effectue les étapes suivantes :
     * <ol>
     *     <li>Demande au joueur de choisir un personnage.</li>
     *     <li>Enregistre le personnage choisi dans la base de données.</li>
     *     <li>Lance le menu principal avec {@link Commands#commandMenu(Character)}.</li>
     *     <li>Ferme le scanner à la fin de la partie.</li>
     * </ol>
     * </p>
     *
     * @throws SQLException si une erreur survient lors de l'enregistrement du héros dans la base.
     */
    public void main() throws SQLException {
        player = chooseCharacter.ChooseCharacter();
        insertHeroDb.createHero(player);
        commands.commandMenu(player);
        clavier.close();
    }

    /**
     * Retourne le personnage actuellement sélectionné par le joueur.
     *
     * @return Le personnage choisi.
     */
    public Character getSelectedCharacter() {
        return player;
    }
}
