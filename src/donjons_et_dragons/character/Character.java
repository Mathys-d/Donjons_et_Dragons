package donjons_et_dragons.character;

/**
 * class Character
 */
public class Character {

    /**
     * initialisation des variables
     */
    protected int id;
    protected String type;
    protected String name;
    protected int hp;
    protected int str;
    protected int position;
    protected String offensiveEquipment;
    protected String defensiveEquipment;

    /**
     * Constructeur pour la création d'un personnage
     * @param name
     * @param type
     * @param position
     * @param offensiveEquipment
     */
    public Character(String name, String type, int position, String offensiveEquipment) {
        this.name = name;
        this.type = type;
        this.offensiveEquipment = offensiveEquipment ;
        this.position = position;
        this.hp = 0;
        this.str = 0;
    }

    /**
     *  Constructeur pour la récupération depuis la BDD
     * @param id
     * @param type
     * @param name
     * @param hp
     * @param str
     * @param offensive
     * @param defensive
     */
    public Character(int id, String type, String name, int hp, int str, String offensive, String defensive) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.hp = hp;
        this.str = str;
        this.offensiveEquipment = offensive;
        this.defensiveEquipment = defensive;
    }


    /**
     * Getters
     * @return
     */
    public String getName() { return name; }
    public int getStr() { return str; }
    public int getHp() { return hp; }
    public String getType() { return type; }
    public int getPosition() { return position; }
    public String getOffensiveEquipment() { return offensiveEquipment; }
    public String getDefensiveEquipment() { return defensiveEquipment; }

    /**
     * Setters
     * @param id
     */
    public void setId(int id) {this.id = id;}

    /**
     * Setters
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setters
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     *Setters
     * @param str
     */
    public void setStr(int str) {
        this.str = str;
    }

    /**
     * Setters
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Setters
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Setters
     * @param offensiveEquipment
     */
    public void setOffensiveEquipment(String offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    /**
     * Setters
     * @param defensiveEquipment
     */
    public void setDefensiveEquipment(String defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    /**
     * methode bouger
     * @param steps
     */
    public void move(int steps) {
        position += steps;
    }

    /**
     * methode de position de départ
     */
    public void defPosition() {
        position = 0;
    }

    /**
     * toString qui donne toutes les infos sur le character
     * @return
     */
    @Override
    public String toString() {
        return "Character{" +"\n" +
                "id = " + id +"\n" +
                "type = " + type + "\n" +
                "name = " + name + "\n" +
                "hp = " + hp +"\n" +
                "str = " + str +"\n" +
                "offensiveEquipment = " + offensiveEquipment + "\n" +
                "defensiveEquipment = " + defensiveEquipment + "\n" +
                "position = " + position +"\n" +
                '}';
    }
}