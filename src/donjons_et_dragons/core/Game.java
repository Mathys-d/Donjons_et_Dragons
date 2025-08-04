package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.board.Cell;
import donjons_et_dragons.board.Dice;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.enemies.Enemy;
import donjons_et_dragons.equipment.Potion;
import donjons_et_dragons.equipment.Shield;
import donjons_et_dragons.ui.Menu;
import java.util.Scanner;

public class Game {


        public Character interfaceCharacter;
        public Board board;
        public int steps = 0;
        public Dice dice = new Dice();
        Scanner clavier = new Scanner(System.in);
        Spawner spawner = new Spawner();

        Menu interfaceMenu = new Menu();


        public void start() throws OutOfBoardException {
            Cell[] boardGenerate = board.generateBoard();
            Scanner clavier = new Scanner(System.in);

            Cell finder;
            /**
             * game
             */
            String entree;
            while (true) {
                System.out.println("Press [Enter] to roll the dice.");
                entree = clavier.nextLine();

                if (entree.isEmpty()) {

                    if (interfaceCharacter.getPosition() == 0) {
                        System.out.println("You start at " + interfaceCharacter.getPosition());
                    }
                    //steps = dice.rollDice();  default
                    steps = 1;
                    interfaceCharacter.move(steps);
                    int pos = interfaceCharacter.getPosition();


                    if (pos < 0 || pos >= boardGenerate.length) {
                        throw new OutOfBoardException("Position hors limit : " + pos);
                    }

                    System.out.println("You step " + steps + " case(s). You are now at : " +
                            interfaceCharacter.getPosition());


                    finder = boardGenerate[interfaceCharacter.getPosition()];

                    if (finder.isHasEnemy()) {
                        Enemy randomEnemy = Enemy.generateRandomEnemy();
                        System.out.println("You encounter a " + randomEnemy.getEnemyName() + " with " +
                                randomEnemy.getEnemyHealth() + " HP and " + randomEnemy.getEnemyStr() + " STR!");
                        System.out.println("Do you want to fight ? (yes/no)");
                        String input = clavier.nextLine();
                        if (input.equalsIgnoreCase("yes")) {
                            System.out.println("You fight it and u win");

                        } else if (input.equalsIgnoreCase("no")) {
                            System.out.println("Looser hah");
                        } else {
                            System.out.println("unknown Command.");
                        }

                    }

                    if (finder.isHasShield()) {
                        Shield randomShield = spawner.generateShieldForCharacter();
                        System.out.println("You found a " + randomShield + " !");
                    }
                    if (finder.isHasPotion()) {
                        Potion randomPotion = spawner.generatePotionForCharacter();
                        System.out.println("You found a " + randomPotion + " !");
                    }

                }  else if (entree.equalsIgnoreCase("quit")) {
                    System.out.println("Back to menu...");
                    return;
                } else {
                    System.out.println("Wrong input.");
                }
                /* if (interfaceCharacter.getPosition() >= 64) {
                 System.out.println("Finish you won !!");
                 }*/
                if (interfaceCharacter.getPosition() >=4) {
                    System.out.println("Finish you won !!");
                }
                if (interfaceCharacter.getHealth() <= 0) {
                    return;
                }

            }

        }
    }
