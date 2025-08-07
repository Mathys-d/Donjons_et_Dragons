package donjons_et_dragons.character;

import donjons_et_dragons.ui.Menu;

import java.util.Scanner;

public class ChoosCharacter {
    protected final Scanner clavier = new Scanner(System.in);
    protected final Menu interfaceMenu;

    public ChoosCharacter(Menu interfaceMenu) {
        this.interfaceMenu = interfaceMenu;
    }

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
