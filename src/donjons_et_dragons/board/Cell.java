package donjons_et_dragons.board;


public class Cell {
    protected boolean hasEnemy;
    protected boolean hasPotion;

    public Cell(boolean hasEnemy, boolean hasPotion) {
        this.hasEnemy = hasEnemy;
        this.hasPotion = hasPotion;
    }

    public boolean isHasEnemy() {
        return hasEnemy;
    }public void setHasEnemy(boolean hasEnemy) {
        this.hasEnemy = hasEnemy;
    }

    public boolean isHasPotion() {
        return hasPotion;
    }public void setHasPotion(boolean hasPotion) {
        this.hasPotion = hasPotion;
    }

    @Override
    public String toString() {
        if (hasEnemy) return "Enemy";
        if (hasPotion) return "+Potion";
        return ".";
    }
}