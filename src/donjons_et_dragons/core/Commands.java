package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.board.Dice;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.ui.Menu;
import java.util.Scanner;

public class Commands {
    public Character interfaceCharacter;
    public Board board;
    public int steps = 0;
    public Dice dice = new Dice();
    Scanner clavier = new Scanner(System.in);
    Game game = new Game();


    Menu interfaceMenu = new Menu();




    public void commandMenu(Character player) {
        this.interfaceCharacter = player;
        while (true) {
            System.out.print("Command (start / info / quit) : ");
            String input = clavier.nextLine();



            if (input.equalsIgnoreCase("quit")) {
                System.out.print("Do you want to leave ? (yes/no) : ");
                String confirm = clavier.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    System.out.println("Game closed.");
                    break;
                }
            } if (input.equalsIgnoreCase("info")) {
                interfaceMenu.displayCharacter(interfaceCharacter);
            } else if (input.equalsIgnoreCase("start")) {
                try {
                    game.interfaceCharacter = interfaceCharacter;
                    game.board = new Board(4);

                    game.start();
                } catch (OutOfBoardException e) {
                    System.out.println(e.getMessage());
                    System.out.println("You win");
                    interfaceCharacter.defPosition();
                }
            } else {
                System.out.println("unknown Command.");
            }
        }
    }
}
