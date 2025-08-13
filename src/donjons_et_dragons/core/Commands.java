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

public class Commands {
    protected Character interfaceCharacter;
    protected Board board;
    protected int steps = 0;
    protected Dice dice = new Dice();
    Scanner clavier = new Scanner(System.in);
    Game game = new Game();
    MainDbConnexion connexion = new MainDbConnexion();
    Menu interfaceMenu = new Menu();
    ChoosCharacter chooseCharacter =  new ChoosCharacter(interfaceMenu);
    protected Character player;
    Scanner scanner = new Scanner(System.in);
    editNameDbConnexion editName = new editNameDbConnexion();


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
            } if (input.equalsIgnoreCase("info")) {
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
                    System.out.print("which hero would you edit: ? ");
                    String changingName = scanner.nextLine().trim();
                    if (changingName.isEmpty()) {
                        System.out.println("entree is empty.");
                    }else {
                        System.out.print("write your new name: ? ");
                        String newName = clavier.nextLine();
                        try {
                            editNameDbConnexion.editHero(changingName, newName);
                            player.setName(newName);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
            }else {
                System.out.println("unknown Command.");
            }
        }
    }
}