package donjons_et_dragons.board;

/**
 * class cellule
 */
public class Cell {
    protected boolean hasEnemy;
    protected boolean hasPotion;
    protected boolean hasShield;
    protected boolean hasWeapon;
    protected boolean hasSpell;

    /**
     * constructeur de la class
     * @param hasEnemy
     * @param hasPotion
     * @param hasShield
     * @param hasWeapon
     * @param hasSpell
     */
    public Cell(boolean hasEnemy, boolean hasPotion, boolean hasShield, boolean hasWeapon, boolean hasSpell) {
        this.hasEnemy = hasEnemy;
        this.hasPotion = hasPotion;
        this.hasShield = hasShield;
        this.hasWeapon = hasWeapon;
        this.hasSpell = hasSpell;
    }

    /**
     * boolean de la cellule enemy
     * @return
     */
    public boolean isHasEnemy() {
        return hasEnemy;
    }public void setHasEnemy(boolean hasEnemy) {
        this.hasEnemy = hasEnemy;
    }

    /**
     * boolean de la cellule shield
     * @return
     */
    public boolean isHasShield() {
        return hasShield;
    }public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    /**
     * boolean de la cellule potion
     * @return
     */
    public boolean isHasPotion() {
        return hasPotion;
    }public void setHasPotion(boolean hasPotion) {
        this.hasPotion = hasPotion;
    }

    /**
     * boolean de la cellule weapon
     * @return
     */
    public boolean isHasWeapon() {
        return hasWeapon;
    }public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    /**
     * boolean de la cellule spell
     * @return
     */
    public boolean isHasSpell() {
        return hasSpell;
    }public void setHasSpell(boolean hasSpell) {
        this.hasSpell = hasSpell;
    }


    /**
     * le toString
     * @return
     */
    @Override
    public String toString() {
        if (hasEnemy) return "Enemy";
        if (hasPotion) return "+Potion";
        if (hasShield) return "+Shield";
        if (hasWeapon) return "+Weapon";
        if (hasSpell) return "+Spell";

        return ".";
    }
}