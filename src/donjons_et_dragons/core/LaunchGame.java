package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.character.ChoosCharacter;
import donjons_et_dragons.ui.Menu;
import java.util.Scanner;

public class LaunchGame {
    Scanner clavier = new Scanner(System.in);
    Menu interfaceMenu = new Menu();
    ChoosCharacter chooseCharacter =  new ChoosCharacter(interfaceMenu);
    Commands commands = new Commands();
    Board board = new Board(4);

    public void main() {
        Character player = chooseCharacter.ChooseCharacter();
        commands.commandMenu(player);
        clavier.close();
    }
}