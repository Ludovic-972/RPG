package objects.items;


import decorator.DecorateurEquipement;

public class CasqueBois extends DecorateurEquipement {

    int addHp;
    public CasqueBois(Armure armure, int addHp)
    {
        super.armure=armure;
        this.addHp = addHp;
    }
    @Override
    public String getDescription() {
        return armure.getDescription() + "\nUn casque en bois, fragile mais efficace ! +" + this.getAddHp() + " HP MAX !";
    }

    @Override
    public int getAddHp() {
        return this.addHp;
    }
    @Override
    public String toString() {
        return "Casque en bois";
    }

}
