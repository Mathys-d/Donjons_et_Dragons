package donjons_et_dragons.core;

import donjons_et_dragons.board.Board;
import donjons_et_dragons.board.Cell;
import donjons_et_dragons.board.Dice;
import donjons_et_dragons.character.Character;
import donjons_et_dragons.enemies.Enemy;
import donjons_et_dragons.equipment.OffensiveEquipment;
import donjons_et_dragons.equipment.consumable.Potion;
import donjons_et_dragons.equipment.defensive.Shield;
import donjons_et_dragons.ui.Menu;
import java.sql.SQLException;
import java.util.Scanner;
import static donjons_et_dragons.db.queryDb.editHpChangeDbConnexion.changingHp;
import static donjons_et_dragons.db.queryDb.editStr.changingWeapon;


public class Game {
        public Character player;
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

                    if (player.getPosition() == 0) {
                        System.out.println("You start at " + player.getPosition());
                    }

                    steps = dice.sixdice();  //default
                    //steps = 1;
                    player.move(steps);
                    int pos = player.getPosition();

                    if (pos < 0 || pos >= boardGenerate.length) {
                        throw new OutOfBoardException("Position hors limit : " + pos);
                    }

                    System.out.println("You step " + steps + " case(s). You are now at : " +
                            player.getPosition());

                    finder = boardGenerate[player.getPosition()];
                    // la case a un ennemy et le code suivant genere un ennemy aleatoire avec un systeme de dée et combat
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

                                if (fighting.isEmpty()) {
                                    dice.actionDice();
                                    res = dice.getActionDiceNumber();
                                    System.out.println("you made " + res);
                                    if (res >= 10 && res != 20) {
                                        atk = player.getStr();
                                        damage = randomEnemy.getEnemyHealth() - atk;
                                        randomEnemy.setEnemyHealth(damage);
                                        System.out.println("your attack made " + atk);
                                        System.out.println("enemy have " + randomEnemy.getEnemyHealth() + " hp now");

                                        if (randomEnemy.getEnemyHealth() <= 0) {
                                            EnemyCpt = 0;
                                            System.out.println("you win the fight against " + randomEnemy.getEnemyName() + " you can continue the adventure");
                                        }
                                    } else if (res == 1) {
                                        System.out.println("critical fail, you made 1, you die.");
                                        player.setHp(0);
                                    } else if (res == 20) {
                                        System.out.println("epic roll you made 20, you one shot the enemy.");
                                        randomEnemy.setEnemyHealth(50);
                                    }else{
                                        damage = player.getStr() - randomEnemy.getEnemyStr();
                                        enemyChargeAtk(damage);
                                    }
                                }
                            }
                            else if (input.equalsIgnoreCase("no")) {
                                System.out.println("You dont want to fight it, press [ENTER] to roll the dice and try to escape");
                                dice.actionDice();
                                res = dice.getActionDiceNumber();
                                System.out.println("you made " + res );

                                if (res >= 10){
                                    EnemyCpt = 0;
                                    System.out.println("You successfully escape");
                                } else if (res == 1) {
                                    System.out.println("critical fail, you made 1, you die.");
                                    player.setHp(0);
                                }else if (res == 20) {
                                    System.out.println("epic roll you made 20, the enemy die instantly, no need to run 'relax'.");
                                    randomEnemy.setEnemyHealth(50);
                                }else{
                                    damage = player.getStr() - randomEnemy.getEnemyStr();
                                    enemyChargeAtk(damage);
                                }
                            } else {
                                System.out.println("unknown Command.");
                            }
                        }
                    }
                    // mes cases spécailes
                    //case shield qui donne un nb de vie en +
                    if (finder.isHasShield()) {
                        Shield randomShield = spawner.generateShieldForCharacter();
                        player.setHp(player.getHp() + randomShield.getPvChange());

                        changingHp(player.getName(), player.getHp());
                        System.out.println("You found a " + randomShield + " !");
                    }
                    //case Potion qui donne un nb de vie en +

                    if (finder.isHasPotion()) {
                        Potion randomPotion = spawner.generatePotionForCharacter();
                        player.setHp(player.getHp() + randomPotion.getPvChange());
                        changingHp(player.getName(), player.getHp());
                        System.out.println("You found a " + randomPotion + " !");
                    }

                    //mettre la condition si il est de la class warrior ou wizard

                    //case Weapon qui donne une arme aleatoire et permet de changer si on veut
                    if (finder.isHasWeapon()) {
                        if (player.getType().equals("warrior")) {
                            OffensiveEquipment randomWeapon = spawner.generateWeaponForCharacter();
                            System.out.println("You found a " + randomWeapon.getOffensiveEquipmentName() + " !" + "do you want to change your " + player.getOffensiveEquipment() + " with " + player.getStr() + " damage." + "(YES/NO)");
                            String input = clavier.nextLine();
                            if (input.equalsIgnoreCase("yes")) {
                                player.setStr(randomWeapon.getDamage());
                                player.setOffensiveEquipment(randomWeapon.getOffensiveEquipmentName());
                                changingWeapon(player.getName(), player.getStr(), player.getOffensiveEquipment());
                                System.out.println("You replace your weapon with a " + randomWeapon + " !");
                            }
                            if (input.equalsIgnoreCase("no")) {
                                System.out.println("you can continue the adventure.");
                            } else {
                                System.out.println("unknown Command.");
                            }
                        }
                        System.out.println("vous etes sur une case reservé a la classe warrior.");
                    }
                    //case Spell qui donne une arme aleatoire et permet de changer si on veut
                    if (finder.isHasSpell()) {
                        if (player.getType().equals("wizard")) {
                            OffensiveEquipment randomSpell = spawner.generateSpellForCharacter();
                            System.out.println("You found a " + randomSpell + " !" + "do you want to change your " + player.getOffensiveEquipment() + " with " + player.getStr() + " damage." + "(yes/no)");
                            String input = clavier.nextLine();
                            if (input.equalsIgnoreCase("yes")) {
                                player.setStr(randomSpell.getDamage());
                                player.setOffensiveEquipment(randomSpell.getOffensiveEquipmentName());
                                changingWeapon(player.getName(), player.getStr(), player.getOffensiveEquipment());
                                System.out.println("You replace your spell with a " + randomSpell + " !");
                            }
                            if (input.equalsIgnoreCase("no")) {
                                System.out.println("you can continue the adventure.");
                            } else {
                                System.out.println("unknown Command.");
                            }
                        }
                        System.out.println("vous etes sur une case reservé a la classe wizard.");

                    }
                }  else if (entree.equalsIgnoreCase("quit")) {
                    System.out.println("Back to menu...");
                    return;
                } else {
                    System.out.println("Wrong input.");
                }
                if (player.getPosition() >= 64) {
                    System.out.println("Finish you won !!");
                }
                if (player.getHp() <= 0) {
                    return;
                }
                changingHp(player.getName(), player.getHp());
            }
        }
        public void enemyChargeAtk(int damage){
            player.setHp(player.getHp() - damage);
            System.out.println("you take "+ damage +" damage." );
            changingHp(player.getName(), player.getHp());
            if (player.getHp() <= 0) {
                System.out.println("You are dead. Game over.");
                System.exit(0);
            }
        }
}
