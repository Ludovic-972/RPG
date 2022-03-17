package objects.items;

import decorator.DecorateurEquipement;

public class ArmureBois extends DecorateurEquipement {

    int addHp;

    public ArmureBois(Armure armure, int addHp)
    {
        super.armure=armure;
        this.addHp = addHp;
    }
    @Override
    public String getDescription() {
        return armure.getDescription() + "`\nUne armure en bois, fragile mais efficace ! +" + this.getAddHp() + " HP MAX !";
    }

    @Override
    public int getAddHp() {
        return this.addHp;
    }

    @Override
    public String toString() {
        return "Armure en bois";
    }

}

