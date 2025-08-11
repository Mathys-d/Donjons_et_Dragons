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

                    steps = dice.rollDice();  //default
                    //steps = 1;
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
                    // mes cases spécailes
                    //case shield qui donne un nb de vie en +
                    if (finder.isHasShield()) {
                        Shield randomShield = spawner.generateShieldForCharacter();
                        interfaceCharacter.setHp(interfaceCharacter.getHp() + randomShield.getPvChange());

                        changingHp(interfaceCharacter.getName(),interfaceCharacter.getHp());
                        System.out.println("You found a " + randomShield + " !");
                    }
                    //case Potion qui donne un nb de vie en +

                    if (finder.isHasPotion()) {
                        Potion randomPotion = spawner.generatePotionForCharacter();
                        interfaceCharacter.setHp(interfaceCharacter.getHp() + randomPotion.getPvChange());
                        changingHp(interfaceCharacter.getName(),interfaceCharacter.getHp());
                        System.out.println("You found a " + randomPotion + " !");
                    }

                    //mettre la condition si il est de la class warrior ou wizard

                    //case Weapon qui donne une arme aleatoire et permet de changer si on veut
                    if (finder.isHasWeapon()) {
                        if (interfaceCharacter.getType().equals("warrior")) {
                            OffensiveEquipment randomWeapon = spawner.generateWeaponForCharacter();
                            System.out.println("You found a " + randomWeapon + " !" + "do you want to change your " + interfaceCharacter.getOffensiveEquipment() + " with " + interfaceCharacter.getStr() + " damage." + "(YES/NO)");
                            String input = clavier.nextLine();
                            if (input.equalsIgnoreCase("yes")) {
                                interfaceCharacter.setStr(randomWeapon.getDamage());
                                interfaceCharacter.setOffensiveEquipment(randomWeapon.getOffensiveEquipmentName());
                                changingWeapon(interfaceCharacter.getName(), interfaceCharacter.getStr(), interfaceCharacter.getOffensiveEquipment());
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
                        if (interfaceCharacter.getType().equals("wizard")) {
                            OffensiveEquipment randomSpell = spawner.generateSpellForCharacter();
                            System.out.println("You found a " + randomSpell + " !" + "do you want to change your " + interfaceCharacter.getOffensiveEquipment() + " with " + interfaceCharacter.getStr() + " damage." + "(yes/no)");
                            String input = clavier.nextLine();
                            if (input.equalsIgnoreCase("yes")) {
                                interfaceCharacter.setStr(randomSpell.getDamage());
                                interfaceCharacter.setOffensiveEquipment(randomSpell.getOffensiveEquipmentName());
                                changingWeapon(interfaceCharacter.getName(), interfaceCharacter.getStr(), interfaceCharacter.getOffensiveEquipment());
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
                if (interfaceCharacter.getPosition() >= 64) {
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
