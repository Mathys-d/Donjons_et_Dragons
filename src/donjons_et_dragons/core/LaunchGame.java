package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.character.ChoosCharacter;
import donjons_et_dragons.db.ConnexionDb;
import donjons_et_dragons.ui.Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class LaunchGame {
    Scanner clavier = new Scanner(System.in);
    Menu interfaceMenu = new Menu();
    ChoosCharacter chooseCharacter =  new ChoosCharacter(interfaceMenu);
    Commands commands = new Commands();
    Board board = new Board(4);
    protected Character player;
    ConnexionDb connexion = new ConnexionDb();

    public void main() throws SQLException {
        player = chooseCharacter.ChooseCharacter();
        connexion.createHero(player);
        commands.commandMenu(player);
        clavier.close();
    }


    public Character getSelectedCharacter() {
        return player;
    }
}