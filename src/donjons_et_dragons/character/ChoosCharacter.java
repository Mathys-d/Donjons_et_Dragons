package donjons_et_dragons.character;

import donjons_et_dragons.ui.Menu;

import java.util.Scanner;

public class ChoosCharacter {
    protected final Scanner clavier = new Scanner(System.in);
    protected final Menu interfaceMenu;

    /**
     * Constructeur pour la creation du type de character
     * @param interfaceMenu
     */
    public ChoosCharacter(Menu interfaceMenu) {
        this.interfaceMenu = interfaceMenu;
    }

    /**
     * methode qui cree le character avec son equipement
     * @return
     */
    public Character ChooseCharacter() {
        String name = interfaceMenu.chooseName(clavier);
        String type = interfaceMenu.chooseClass(clavier);
        String weapon = interfaceMenu.chooseWeapon(clavier, type);
        interfaceMenu.showMessage(name, type, weapon);

        if (type.equalsIgnoreCase("wizard")) {
            return new Wizard(name, weapon);
        } else if (type.equalsIgnoreCase("warrior")) {
            return new Warrior(name, weapon);
        } else {
            System.out.println("Invalid class. Default character: Warrior.");
            return new Warrior(name, "sword");
        }
    }

}