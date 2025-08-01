package donjons_et_dragons.character;

import java.util.Random;

public class Wizard extends Character {
    public Wizard(String name) {
        super(name, "wizard", 0);
        Random rand = new Random();

        this.health = rand.nextInt(8) + 8;
        this.power = rand.nextInt(4) + 3;
    }

    @Override
    public String toString() {
        return
                "name: " + name + "\n" +
                ", health: " + health + "\n" +
                ", power: " + power + "\n" +
                ", type: " + type ;
    }
}
