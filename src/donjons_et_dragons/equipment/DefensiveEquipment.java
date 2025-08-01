package donjons_et_dragons.equipment;

public abstract class DefensiveEquipment {

    protected String DefensiveEquipment;
    protected int pvChange;


    public DefensiveEquipment (int pvChange,  String DefensiveEquipment){
        this.DefensiveEquipment = DefensiveEquipment;
        this.pvChange = pvChange;
    }

    public String getDefensiveEquipment() {
        return DefensiveEquipment;
    }public void setDefensiveEquipment(String defensiveEquipment) {
        DefensiveEquipment = defensiveEquipment;
    }

    public int getPvChange() {
        return pvChange;
    }public void setPvChange(int pvChange) {
        this.pvChange = pvChange;
    }
}
