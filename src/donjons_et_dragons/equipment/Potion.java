package donjons_et_dragons.equipment;

import java.util.Random;

public class Potion extends DefensiveEquipment {


    public Potion(int pvHealed , String potion) {
        super(pvHealed,potion);
    }




    private static int generalHealForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2)+1;
        switch (r) {
            case 1:
                return 2 + "potion de vie ordinaire";
            case 2:
                return 5 + "grande potion de vie";
        }
        return 0;
    }
}