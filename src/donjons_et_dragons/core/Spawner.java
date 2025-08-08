package donjons_et_dragons.core;

import donjons_et_dragons.equipment.OffensiveEquipment;
import donjons_et_dragons.equipment.consumable.Potion;
import donjons_et_dragons.equipment.defensive.Shield;
import donjons_et_dragons.equipment.usable.weapon.Masse;
import donjons_et_dragons.equipment.usable.weapon.Sword;

import java.util.Random;

public class Spawner {

    public Potion generatePotionForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        if (r == 1) {
            return new Potion(2);
        }
        return new Potion(5);
    }

    public Shield generateShieldForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        if (r == 1) {
            return new Shield(2);
        }
        return new Shield(10);
    }

    public OffensiveEquipment generateWeaponForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        if (r == 1) {
            return new Masse("Masse",7);
        }
        return new Sword("Sword",6);
    }
}
