package donjons_et_dragons.board;

/**
 * Classe cellule.
 */
public class Cell {
    protected boolean hasEnemy;
    protected boolean hasPotion;
    protected boolean hasShield;
    protected boolean hasWeapon;
    protected boolean hasSpell;

    /**
     * Constructeur de la classe Cell.
     * @param hasEnemy présence d’un ennemi
     * @param hasPotion présence d’une potion
     * @param hasShield présence d’un bouclier
     * @param hasWeapon présence d’une arme
     * @param hasSpell présence d’un sort
     */
    public Cell(boolean hasEnemy, boolean hasPotion, boolean hasShield, boolean hasWeapon, boolean hasSpell) {
        this.hasEnemy = hasEnemy;
        this.hasPotion = hasPotion;
        this.hasShield = hasShield;
        this.hasWeapon = hasWeapon;
        this.hasSpell = hasSpell;
    }

    /**
     * Indique si la cellule contient un ennemi.
     * @return true si oui, false sinon
     */
    public boolean isHasEnemy() {
        return hasEnemy;
    }
    public void setHasEnemy(boolean hasEnemy) {
        this.hasEnemy = hasEnemy;
    }

    /**
     * Indique si la cellule contient un bouclier.
     * @return true si oui, false sinon
     */
    public boolean isHasShield() {
        return hasShield;
    }
    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    /**
     * Indique si la cellule contient une potion.
     * @return true si oui, false sinon
     */
    public boolean isHasPotion() {
        return hasPotion;
    }
    public void setHasPotion(boolean hasPotion) {
        this.hasPotion = hasPotion;
    }

    /**
     * Indique si la cellule contient une arme.
     * @return true si oui, false sinon
     */
    public boolean isHasWeapon() {
        return hasWeapon;
    }
    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    /**
     * Indique si la cellule contient un sort.
     * @return true si oui, false sinon
     */
    public boolean isHasSpell() {
        return hasSpell;
    }
    public void setHasSpell(boolean hasSpell) {
        this.hasSpell = hasSpell;
    }

    /**
     * Représentation textuelle de la cellule.
     * @return description sous forme de chaîne
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
