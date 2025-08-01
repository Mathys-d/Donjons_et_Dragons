package donjons_et_dragons.board;


public class Cell {
    protected boolean hasEnemy;
    protected boolean DefensiveEquipment;

    public Cell(boolean hasEnemy, boolean DefensiveEquipment) {
        this.hasEnemy = hasEnemy;
        this.DefensiveEquipment = DefensiveEquipment;
    }

    public boolean isHasEnemy() {
        return hasEnemy;
    }public void setHasEnemy(boolean hasEnemy) {
        this.hasEnemy = hasEnemy;
    }

    public boolean isDefensiveEquipment() {
        return DefensiveEquipment;
    }public void setDefensiveEquipment(boolean defensiveEquipment) {
        DefensiveEquipment = defensiveEquipment;
    }

    @Override
    public String toString() {
        if (hasEnemy) return "Enemy";
        if (DefensiveEquipment) return "Its a Defensive Equipment";
        return ".";
    }
}