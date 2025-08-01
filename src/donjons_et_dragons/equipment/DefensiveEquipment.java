package donjons_et_dragons.equipment;

public abstract class DefensiveEquipment {

    protected String defensiveEquipment;
    protected int pvChange;


    public DefensiveEquipment (int pvChange,  String DefensiveEquipment){
        this.defensiveEquipment = DefensiveEquipment;
        this.pvChange = pvChange;
    }

    public String getDefensiveEquipment() {
        return defensiveEquipment;
    }public void setDefensiveEquipment(String defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    public int getPvChange() {
        return pvChange;
    }public void setPvChange(int pvChange) {
        this.pvChange = pvChange;
    }
}
