package donjons_et_dragons.equipment.defensive;


import donjons_et_dragons.equipment.DefensiveEquipment;

import java.util.Random;

public class Shield extends DefensiveEquipment {

    public Shield(int pvDealt) {
        super(pvDealt);
    }

    private static int generalHealForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2)+1;
        return switch (r) {
            case 1 -> 2 ;
            case 2 -> 10;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "the shield give you a bonus of " + getPvChange() + " HP)";
    }
}