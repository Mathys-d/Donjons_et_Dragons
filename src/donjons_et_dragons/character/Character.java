package donjons_et_dragons.character;

public class Character {

    protected int id;
    protected String type;
    protected String name;
    protected int hp;
    protected int str;
    protected int position;
    protected String offensiveEquipment;
    protected String defensiveEquipment;

    // Constructeur pour la création d'un personnage
    public Character(String name, String type, int position, String offensiveEquipment) {
        this.name = name;
        this.type = type;
        this.offensiveEquipment = offensiveEquipment ;
        this.position = position;
        this.hp = 0;
        this.str = 0;
    }

    // Constructeur pour la récupération depuis la BDD
    public Character(int id, String type, String name, int hp, int str, String offensive, String defensive) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.hp = hp;
        this.str = str;
        this.offensiveEquipment = offensive;
        this.defensiveEquipment = defensive;
    }


    // Getters
    public String getName() { return name; }
    public int getStr() { return str; }
    public int getHp() { return hp; }
    public String getType() { return type; }
    public int getPosition() { return position; }
    public String getOffensiveEquipment() { return offensiveEquipment; }
    public String getDefensiveEquipment() { return defensiveEquipment; }

    // Setters
    public void setId(int id) {this.id = id;}
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setStr(int str) {
        this.str = str;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void setOffensiveEquipment(String offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }
    public void setDefensiveEquipment(String defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    public void move(int steps) {
        position += steps;
    }
    public void defPosition() {
        position = 0;
    }

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