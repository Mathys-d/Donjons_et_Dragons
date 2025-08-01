package donjons_et_dragons.equipment;

public class DefensiveEquipment {

    protected String potion;
    protected int pvHealed;

    public DefensiveEquipment (int pvHealed,  String potion){
        this.pvHealed = pvHealed;
        this.potion = potion;
    }

    public int getPvHealed() {
        return pvHealed;
    }public void setPvHealed(int pvHealed) {
        this.pvHealed = pvHealed;
    }

    public String getPotion() {
        return potion;
    }public void setPotion(String potion) {
        this.potion = potion;
    }
}
