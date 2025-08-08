package donjons_et_dragons.board;


public class Cell {
    protected boolean hasEnemy;
    protected boolean hasPotion;
    protected boolean hasShield;
    protected boolean hasWeapon;
    protected boolean hasSpell;


    public Cell(boolean hasEnemy, boolean hasPotion, boolean hasShield, boolean hasWeapon, boolean hasSpell) {
        this.hasEnemy = hasEnemy;
        this.hasPotion = hasPotion;
        this.hasShield = hasShield;
        this.hasWeapon = hasWeapon;
        this.hasSpell = hasSpell;
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

    public boolean isHasWeapon() {
        return hasWeapon;
    }public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    public boolean isHasSpell() {
        return hasSpell;
    }public void setHasSpell(boolean hasSpell) {
        this.hasSpell = hasSpell;
    }

    @Override
    public String toString() {
        if (hasEnemy) return "Enemy";
        if (hasPotion) return "+Potion";
        if (hasShield) return "+Shield";
        if (hasWeapon) return "+Weapon";
        if (hasSpell) return "+Spell";

        return ".";
    }

    public void interact(Character character) {
    }
}