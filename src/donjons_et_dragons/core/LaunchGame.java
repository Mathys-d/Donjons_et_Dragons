package donjons_et_dragons.core;

import donjons_et_dragons.character.Character;
import donjons_et_dragons.character.ChoosCharacter;
import donjons_et_dragons.db.MainDbConnexion;
import donjons_et_dragons.db.queryDb.insertHeroDbConnexion;
import donjons_et_dragons.ui.Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class LaunchGame {
    Scanner clavier = new Scanner(System.in);
    Menu interfaceMenu = new Menu();
    ChoosCharacter chooseCharacter =  new ChoosCharacter(interfaceMenu);
    Commands commands = new Commands();
    protected Character player;
    MainDbConnexion connexion = new MainDbConnexion();
    insertHeroDbConnexion insertHeroDb = new insertHeroDbConnexion();

    public void main() throws SQLException {
        player = chooseCharacter.ChooseCharacter();
        insertHeroDb.createHero(player);
        commands.commandMenu(player);
        clavier.close();
    }


    public Character getSelectedCharacter() {
        return player;
    }
}