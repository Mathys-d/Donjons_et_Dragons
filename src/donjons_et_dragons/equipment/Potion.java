package donjons_et_dragons.equipment;

public class Potion extends DefensiveEquipment {
    public Potion(int pvHealed , String potion) {
        super(pvHealed,potion);
    }
    private static int generalHealForCharacter(String potion) {
        switch (potion.toLowerCase()) {
            case "potion de vie ordinaire":
                return 2;
            case "grande potion de vie":
                return 5;
        }
        return 0;
    }
}