package donjons_et_dragons.board;


public class Cell {
    protected boolean hasEnemy;
    protected boolean hasPotion;
    protected boolean hasShield;

    public Cell(boolean hasEnemy, boolean hasPotion, boolean hasShield) {
        this.hasEnemy = hasEnemy;
        this.hasPotion = hasPotion;
        this.hasShield = hasShield;
    }

    public boolean isHasEnemy() {
        return hasEnemy;
    }public void setHasEnemy(boolean hasEnemy) {
        this.hasEnemy = hasEnemy;
    }

    public boolean isHasShield() {
        return hasShield;
    }public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
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
        if (hasShield) return "+Shield";
        return ".";
    }
}