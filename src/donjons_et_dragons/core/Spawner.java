package donjons_et_dragons.core;

import donjons_et_dragons.equipment.OffensiveEquipment;
import donjons_et_dragons.equipment.consumable.Potion;
import donjons_et_dragons.equipment.defensive.Shield;
import donjons_et_dragons.equipment.usable.weapon.Masse;
import donjons_et_dragons.equipment.usable.weapon.Sword;

import java.util.Random;

/**
 * Classe responsable de la génération aléatoire d'équipements pour les personnages.
 */
public class Spawner {

    /**
     * Génère une potion pour un personnage, de taille aléatoire.
     *
     * @return une potion
     */
    public Potion generatePotionForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        if (r == 1) {
            return new Potion(2);
        }
        return new Potion(5);
    }

    /**
     * Génère un bouclier pour un personnage, de valeur aléatoire.
     *
     * @return un bouclier
     */
    public Shield generateShieldForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        if (r == 1) {
            return new Shield(2);
        }
        return new Shield(10);
    }

    /**
     * Génère une arme offensive pour un personnage, au hasard entre Masse et Sword.
     *
     * @return une arme offensive
     */
    public OffensiveEquipment generateWeaponForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        if (r == 1) {
            return new Masse("Masse", 7);
        }
        return new Sword("Sword", 6);
    }

    /**
     * Génère un sort offensif pour un personnage, au hasard entre Masse et Sword (utilisé comme sorts).
     *
     * @return un sort offensif
     */
    public OffensiveEquipment generateSpellForCharacter() {
        Random rand = new Random();
        int r = rand.nextInt(2) + 1;
        if (r == 1) {
            return new Masse("Fire ball", 7);
        }
        return new Sword("lightning", 6);
    }
}
