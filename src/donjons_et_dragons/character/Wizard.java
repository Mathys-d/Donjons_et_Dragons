package donjons_et_dragons.character;

import java.util.Random;

public class Wizard extends Character {

    public Wizard(String name, String weapon) {
        super(name, "wizard", 0, weapon);
        Random rand = new Random();

        this.hp = 5 + rand.nextInt(6);
        this.str = 2 + rand.nextInt(9);
    }

    @Override
    public String toString() {
        return
                "id: "+ id + "\n" +
                "name:" + name + "\n" +
                "type: " + type +"\n" +
                "hp:" + hp +"\n" +
                "str:" + str +"\n" +
                "offensive:" + offensiveEquipment + "\n";
    }
}
