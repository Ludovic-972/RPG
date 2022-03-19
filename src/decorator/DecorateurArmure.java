package decorator;

import objects.items.Armure;

public abstract class DecorateurArmure extends Armure {
    protected Armure armure;
    public abstract String getDescription();
    public abstract int getAddHp();

}
