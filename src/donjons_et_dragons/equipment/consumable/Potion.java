package donjons_et_dragons.equipment.consumable;

import donjons_et_dragons.equipment.DefensiveEquipment;

import java.util.Random;

public class Potion extends DefensiveEquipment {

    public Potion(int pvHealed) {
        super(pvHealed);
    }

    private static int generalHealForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2)+1;
        return switch (r) {
            case 1 -> 2;
            case 2 -> 5;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return  "the potion give you a bonus of " + getPvChange() + " HP";
    }

}