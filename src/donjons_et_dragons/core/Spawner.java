package donjons_et_dragons.core;

import donjons_et_dragons.equipment.Potion;
import donjons_et_dragons.equipment.Shield;

import java.util.Random;

public class Spawner {

    public Potion generatePotionForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        switch (r) {
            case 1:
                return new Potion(2, "ordinary Potion");
            default:
                return new Potion(5, "big Potion");
        }
    }

    public Shield generateShieldForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        switch (r) {
            case 1:
                return new Shield(2, "ordinary shield");
            default:
                return new Shield(10, "big shield");
        }
    }
}
