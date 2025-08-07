package donjons_et_dragons.core;

import donjons_et_dragons.Main;
import donjons_et_dragons.board.Board;
import donjons_et_dragons.board.Cell;
import donjons_et_dragons.board.Dice;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.enemies.Enemy;
import donjons_et_dragons.equipment.Potion;
import donjons_et_dragons.equipment.Shield;
import donjons_et_dragons.ui.Menu;

import java.sql.SQLException;
import java.util.Scanner;


public class Game {


        public Character interfaceCharacter;
        public Board board;
        public int steps = 0;
        public Dice dice = new Dice();
        Scanner clavier = new Scanner(System.in);
        Spawner spawner = new Spawner();
        Game game = new Game();
        Menu interfaceMenu = new Menu();
        int res;
        int atk;
        int damage;
        Main theMain = new Main();



        public void start() throws OutOfBoardException, SQLException {
            Cell[] boardGenerate = board.generateBoard();
            Scanner clavier = new Scanner(System.in);

            Cell finder;
            /**
             * game
             */
            String fighting;
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
                        int EnemyCpt = 1;
                        while (EnemyCpt == 1) {

                            System.out.println("You are in front of a " + randomEnemy.getEnemyName() + " with " +
                                    randomEnemy.getEnemyHealth() + " HP and " + randomEnemy.getEnemyStr() + " STR!");
                            System.out.println("Do you want to fight ? (yes/no)");
                            String input = clavier.nextLine();

                            if (input.equalsIgnoreCase("yes")) {
                                System.out.println("You want to fight it, press [ENTER] to roll the dice for attack");
                                fighting = clavier.nextLine();
                                if (fighting.isEmpty()){
                                    dice.actionDice();
                                     res = dice.actionDiceNumber;
                                    if (res >= 10){
                                        atk = interfaceCharacter.getStr();
                                        randomEnemy.setEnemyHealth(atk);
                                        if (randomEnemy.getEnemyHealth() <= 0) {
                                            EnemyCpt = 0;
                                            System.out.println("you win the fight against "+ randomEnemy.getEnemyName() + "you can continue the adventure");
                                        }
                                    }else{
                                         damage = interfaceCharacter.getStr() - randomEnemy.getEnemyStr();
                                         if (damage <= 0) {
                                             System.out.println("your dead its the end !");
                                             theMain.main();
                                         }
                                    }

                                }
                            }


                            else if (input.equalsIgnoreCase("no")) {
                                System.out.println("You want dont want to fight it, press [ENTER] for escape and roll the dice");
                                dice.actionDice();
                                res = dice.actionDiceNumber;
                                if (res >= 10){
                                    EnemyCpt = 0;
                                }

                            } else {
                                System.out.println("unknown Command.");
                            }
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

                if (interfaceCharacter.getHp() <= 0) {
                    return;
                }

            }

        }

}
