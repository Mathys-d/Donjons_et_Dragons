package donjons_et_dragons.ui;

import donjons_et_dragons.character.Character;

import java.util.Scanner;

public class Menu {

    /**
     * @param clavier
     * @return
     */
    public String chooseName(Scanner clavier){
        System.out.print("Name of the character: : ");
        return clavier.nextLine();
    }

    /**
     * @param clavier
     * @return
     */
    public String chooseClass(Scanner clavier){
        System.out.print("Choose a class (warrior/wizard) : ");
        return clavier.nextLine();
    }

    /**
     * @param clavier
     * @param type
     * @return
     */
    public String chooseWeapon(Scanner clavier,String type) {
         if (type.equalsIgnoreCase("warrior")) {
             System.out.print("Choose a weapon (sword/massue) : ");
         }if (type.equalsIgnoreCase("wizard")) {
            System.out.print("Choose a spell (fire ball/lightning) : ");
        }

        return clavier.nextLine();
    }


    /**
     * @param name
     * @param character
     * @param weapon
     */
    public void showMessage(String name, String character, String weapon){
        System.out.println("Welcome " + name + ", you choose the class " + character + ", your offensive equipment gonna be " + weapon + ".");
    }

    /**
     * @param character
     */
    public void displayCharacter(Character character) {
        System.out.println(character.toString());
    }

    /**
     *
     */
    public void startGame() {

    }


    /**
     *
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