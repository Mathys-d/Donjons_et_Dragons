package donjons_et_dragons.equipment;

public class Shield extends DefensiveEquipment{

    public Shield(int pvDealt, String shield) {
        super(pvDealt,shield);
    }
    private static int generalShieldForCharacter(String shield) {
        switch (shield.toLowerCase()) {
            case "ordinary shield":
                return 2;
            case "big shield":
                return 10;
        }
        return 0;
    }
}