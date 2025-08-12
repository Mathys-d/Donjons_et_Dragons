package donjons_et_dragons.equipment;

public abstract class DefensiveEquipment {

    protected int pvChange;

    public DefensiveEquipment (int pvChange){
        this.pvChange = pvChange;
    }
    public int getPvChange() {
        return pvChange;
    }public void setPvChange(int pvChange) {
        this.pvChange = pvChange;
    }
}