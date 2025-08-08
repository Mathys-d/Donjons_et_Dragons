package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.board.Cell;
import donjons_et_dragons.board.Dice;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.enemies.Enemy;
import donjons_et_dragons.equipment.consumable.Potion;
import donjons_et_dragons.equipment.defensive.Shield;
import donjons_et_dragons.ui.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import static donjons_et_dragons.db.queryDb.editHpChangeDbConnexion.changingHp;


public class Game {


        public Character interfaceCharacter;
        public Board board;
        public int steps = 0;
        public Dice dice = new Dice();
        Scanner clavier = new Scanner(System.in);
        Spawner spawner = new Spawner();
        Menu interfaceMenu = new Menu();
        int res;
        int atk;
        int damage;


        public void start() throws OutOfBoardException, SQLException {
            Cell[] boardGenerate = board.generateBoard();
            Scanner clavier = new Scanner(System.in);
            Cell finder;
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
                                    System.out.println("you made " + res );
                                    if (res >= 10){
                                        atk = interfaceCharacter.getStr();
                                        damage = randomEnemy.getEnemyHealth() - atk ;
                                        randomEnemy.setEnemyHealth(damage);
                                        System.out.println("your attack made " + atk );
                                        System.out.println("enemy have " + randomEnemy.getEnemyHealth()+ " hp now" );

                                        if (randomEnemy.getEnemyHealth() <= 0) {
                                            EnemyCpt = 0;
                                            System.out.println("you win the fight against "+ randomEnemy.getEnemyName() + " you can continue the adventure");
                                        }
                                    }else{
                                        damage = interfaceCharacter.getStr() - randomEnemy.getEnemyStr();
                                        enemyChargeAtk();
                                    }
                                }
                            }
                            else if (input.equalsIgnoreCase("no")) {
                                System.out.println("You dont want to fight it, press [ENTER] to roll the dice and try to escape");
                                dice.actionDice();
                                res = dice.actionDiceNumber;
                                System.out.println("you made " + res );

                                if (res >= 10){
                                    EnemyCpt = 0;
                                    System.out.println("You successfully escape");
                                }else{
                                    damage = interfaceCharacter.getStr() - randomEnemy.getEnemyStr();
                                    enemyChargeAtk();
                                }
                            } else {
                                System.out.println("unknown Command.");
                            }
                        }
                    }

                    if (finder.isHasShield()) {
                        Shield randomShield = spawner.generateShieldForCharacter();
                        interfaceCharacter.setHp(interfaceCharacter.getHp() + randomShield.getPvChange());

                        changingHp(interfaceCharacter.getName(),interfaceCharacter.getHp());
                        System.out.println("You found a " + randomShield + " !");
                    }
                    if (finder.isHasPotion()) {
                        Potion randomPotion = spawner.generatePotionForCharacter();
                        interfaceCharacter.setHp(interfaceCharacter.getHp() + randomPotion.getPvChange());
                        changingHp(interfaceCharacter.getName(),interfaceCharacter.getHp());
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
                changingHp(interfaceCharacter.getName(),interfaceCharacter.getHp());
            }

        }
        public void enemyChargeAtk(){
            interfaceCharacter.setHp(interfaceCharacter.getHp() - damage);
            System.out.println("you take "+ damage +" damage." );
            changingHp(interfaceCharacter.getName(),interfaceCharacter.getHp());
            if (interfaceCharacter.getHp() <= 0) {
                System.out.println("You are dead. Game over.");
                System.exit(0);

            }
        }

}
