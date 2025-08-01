package donjons_et_dragons.character;

public class Character{

    protected String name;
    protected int health;
    protected int str;
    protected int power;
    protected String type;
    protected int position;

    public Character(String name, String type, int position) {
        this.name = name;
        this.type = type;
        this.position = 0;
    }


    public String getName() {
        return name;
    }    public int getStr() {
        return str;
    }public int getPower() {
        return power;
    }public int getHealth() {
        return health;
    }public String getType() {
        return type;
    }public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }public void setHealth(int health) {
        this.health = health;
    }public void setStr(int str) {
        this.str = str;
    }public void setPower(int power) {
        this.power = power;
    }public void setType(String type) {
        this.type = type;
    }public void setPosition(int position) {
        this.position = position;
    }

    public void move(int steps) {
        position = position + steps;
    }
}

