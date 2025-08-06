package donjons_et_dragons.character;

import java.util.Random;

public class Warrior extends Character {
    public Warrior(String name, String weapon) {
        super(name, "warrior",0, weapon);
        Random rand = new Random();

        this.hp = rand.nextInt(5) + 5;
        this.str = rand.nextInt(5) + 5;
    }

    @Override
    public String toString() {
        return"name: " + name + "\n"+
                "health: " + hp + "\n"+
                "str: " + str + "\n"+
                "type: " + type ;
    }
}