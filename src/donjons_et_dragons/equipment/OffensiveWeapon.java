package donjons_et_dragons.equipment;

public class OffensiveWeapon extends OffensiveEquipment {

    public OffensiveWeapon(String weapon) {
        super(weapon, generateDamageForWeapon(weapon));
    }

    private static int generateDamageForWeapon(String weapon) {
        switch (weapon.toLowerCase()) {
            case "sword":
                return 5;
            case "massue":
                return 7;
            case "lightning":
                return 6;
            case "fire ball":
                return 7;
        }
        return 0;
    }
}
