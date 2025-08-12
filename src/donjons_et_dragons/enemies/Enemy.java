package donjons_et_dragons.enemies;

import donjons_et_dragons.board.Cell;
import java.util.Random;

public class Enemy {

    protected String enemyName;
    protected int enemyHealth;
    protected int enemyStr;
    private Random rand = new Random();

    public Enemy(String enemyName, int enemyHealth, int enemyStr) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyStr = enemyStr;
    }

    public String getEnemyName() {
        return enemyName;
    }public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyStr() {
        return enemyStr;
    }public void setEnemyStr(int enemyStr) {
        this.enemyStr = enemyStr;
    }


    public static Enemy generateRandomEnemy() {
        Random rand = new Random();
        int r = rand.nextInt(5);
        return switch (r) {
            case 0 -> new HostileDragon();
            case 1, 2 -> new HostileSorcerer();
            default -> new HostileGobelin();
        };
    }

    @Override
    public String toString() {
        return "donjons_et_dragons.enemies.Enemy: " + enemyName +
                "\nHealth: " + enemyHealth +
                "\nStrength: " + enemyStr;
    }
}
