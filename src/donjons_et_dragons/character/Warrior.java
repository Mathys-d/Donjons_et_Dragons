package donjons_et_dragons.character;

import java.util.Random;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, "warrior",0);
        Random rand = new Random();

        this.health = rand.nextInt(5) + 5;
        this.str = rand.nextInt(5) + 5;
    }

    @Override
    public String toString() {
        return"name: " + name +
                ", health: " + health +
                ", power: " + power +
                ", type: " + type ;
    }
}