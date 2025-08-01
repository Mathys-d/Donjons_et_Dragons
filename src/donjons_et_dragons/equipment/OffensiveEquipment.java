package donjons_et_dragons.equipment;

public abstract class OffensiveEquipment {

    protected String offensiveEquipmentName;
    protected int damage ;

    public OffensiveEquipment(String offensiveEquipmentName, int damage) {
        this.damage = damage;
        this.offensiveEquipmentName = offensiveEquipmentName;
    }

    public String getOffensiveEquipmentName() {
        return offensiveEquipmentName;
    }public void setOffensiveEquipmentName(String offensiveEquipmentName) {
        this.offensiveEquipmentName = offensiveEquipmentName;
    }

    public int getDamage() {
        return damage;
    }public void setDamage(int damage) {
        this.damage = damage;
    }
}