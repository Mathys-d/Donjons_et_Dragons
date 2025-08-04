package donjons_et_dragons.equipment;


import java.util.Random;

public class Shield extends DefensiveEquipment{


    public Shield(int pvDealt, String shield) {
        super(pvDealt, shield);
    }


    private static String generalHealForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2)+1;
        switch (r) {
            case 1:
                return 2 + "potion de vie ordinaire";
            case 2:
                return 10 + "grande potion de vie";
        }
        return 0+"";
    }

    @Override
    public String toString() {
        return getDefensiveEquipment() + " (+" + getPvChange() + " HP)";
    }
}