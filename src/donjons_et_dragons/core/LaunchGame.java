package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.board.Cell;
import donjons_et_dragons.board.Dice;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.character.Warrior;
import donjons_et_dragons.character.Wizard;
import donjons_et_dragons.enemies.Enemy;
import donjons_et_dragons.ui.Menu;

import java.util.Scanner;

public class LaunchGame {
    public Character interfaceCharacter;
    public Board board;
    public int steps = 0;
    public Dice dice= new Dice();
    Scanner clavier = new Scanner(System.in);

    public void main() {

        Scanner clavier = new Scanner(System.in);
        Menu interfaceMenu = new Menu();
        board = new Board(64);


/**
 * 1st stage
 */
        String name = interfaceMenu.chooseName(clavier);
        String type = interfaceMenu.chooseClass(clavier);
        String weapon = interfaceMenu.chooseWeapon(clavier, type);
        interfaceMenu.showMessage(name, type, weapon);

        if (type.equalsIgnoreCase("wizard")) {
            interfaceCharacter = new Wizard(name);
        } else if (type.equalsIgnoreCase("warrior")) {
            interfaceCharacter = new Warrior(name);
        } else {
            System.out.println("Invalid class. default character : Warrior.");
            interfaceCharacter = new Warrior(name);
        }

/**
 * 2nd stage
 */
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
            } else if (input.equalsIgnoreCase("info")) {
                interfaceMenu.displayCharacter(interfaceCharacter);
            } else if (input.equalsIgnoreCase("start")) {
                try {
                    start();
                } catch (OutOfBoardException e) {
                    System.out.println(e.getMessage());
                    System.out.println("You win");
                }
            } else {
                System.out.println("unknown Command.");
            }
        }
        clavier.close();
    }


    /**
     * @throws OutOfBoardException
     */
    public void start ()throws OutOfBoardException{
        Cell[] boardGenerate = board.generateBoard();
        Scanner clavier = new Scanner(System.in);
        Cell finder;
/**
 * game
 */
        while (true) {
            System.out.println("Press [Enter] to roll the dice.");
            String entree = clavier.nextLine();

            if (entree.isEmpty()) {


                if (interfaceCharacter.getPosition()  == 0) {
                    System.out.println("You start at " + interfaceCharacter.getPosition());
                }
                steps = dice.rollDice();
                interfaceCharacter.move(steps);


                int pos = interfaceCharacter.getPosition();
                if (pos < 0 || pos >= boardGenerate.length) {
                    throw new OutOfBoardException("Position hors limit : " + pos);
                }

                System.out.println("You step " + steps + " case(s). You are now at : " +
                interfaceCharacter.getPosition());


                finder = boardGenerate [interfaceCharacter.getPosition()];

                if (finder.isHasEnemy()) {
                    Enemy randomEnemy = Enemy.generateRandomEnemy();
                    System.out.println("You encounter a " + randomEnemy.getEnemyName() + " with " +
                    randomEnemy.getEnemyHealth() + " HP and " + randomEnemy.getEnemyStr() + " STR!");
                    System.out.println("Do you want to fight ? (yes/no)");
                    String input = clavier.nextLine();
                    if (input.equalsIgnoreCase("yes")) {
                        System.out.println("You fight it and u win");

                    }else if (input.equalsIgnoreCase("no")) {
                        System.out.println("Looser hah");
                    }else {
                        System.out.println("unknown Command.");
                    }

                }


            } else if (entree.equalsIgnoreCase("quit")) {
                System.out.println("Back to menu...");
                break;
            } else {
                System.out.println("Wrong input.");
            } if (interfaceCharacter.getPosition()  >= 64) {
                System.out.println("Finish you won !!");
            } if (interfaceCharacter.getHealth() <= 0) {
                break;
            }

        }//throw new OutOfBoardException
    }
}