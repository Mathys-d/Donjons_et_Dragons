package donjons_et_dragons.ui;

import donjons_et_dragons.character.Character;
import java.util.Scanner;

/**
 * Classe gérant le menu d'interaction utilisateur.
 */
public class Menu {

    /**
     * Demande à l'utilisateur de choisir un nom.
     *
     * @param clavier scanner pour la saisie
     * @return le nom choisi
     */
    public String chooseName(Scanner clavier){
        System.out.print("Name of the character: : ");
        return clavier.nextLine();
    }

    /**
     * Demande à l'utilisateur de choisir une classe.
     *
     * @param clavier scanner pour la saisie
     * @return la classe choisie
     */
    public String chooseClass(Scanner clavier){
        System.out.print("Choose a class (warrior/wizard) : ");
        return clavier.nextLine();
    }

    /**
     * Demande à l'utilisateur de choisir une arme ou un sort selon le type.
     *
     * @param clavier scanner pour la saisie
     * @param type    type de personnage (warrior ou wizard)
     * @return l'équipement offensif choisi
     */
    public String chooseWeapon(Scanner clavier, String type) {
        if (type.equalsIgnoreCase("warrior")) {
            System.out.print("Choose a weapon (sword/massue) : ");
        }
        if (type.equalsIgnoreCase("wizard")) {
            System.out.print("Choose a spell (fire ball/lightning) : ");
        }

        return clavier.nextLine();
    }

    /**
     * Affiche un message récapitulatif du choix du personnage.
     *
     * @param name      nom du personnage
     * @param character classe choisie
     * @param weapon    équipement offensif choisi
     */
    public void showMessage(String name, String character, String weapon){
        System.out.println("Welcome " + name + ", you choose the class " + character + ", your offensive equipment gonna be " + weapon + ".");
    }

    /**
     * Affiche les informations du personnage.
     *
     * @param character personnage à afficher
     */
    public void displayCharacter(Character character) {
        System.out.println(character.toString());
    }

    /**
     * Démarre le jeu (fonction à implémenter).
     */
    public void startGame() {

    }

    /**
     * Demande à l'utilisateur s'il veut quitter et ferme le programme si oui.
     */
    public void quit() {
        Scanner clavier = new Scanner(System.in);

        System.out.print("Leave ? (yes/no) : ");
        String message = clavier.nextLine();

        if (message.equals("yes")) {
            System.out.println("Game closed.");
            System.exit(0);
        }
    }
}
