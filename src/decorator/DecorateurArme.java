package decorator;

import objects.items.Arme;
import objects.items.Armure;

public abstract class DecorateurArme extends Arme {
    protected Arme arme;
    public abstract String getDescription();
    public abstract int getAddAtk();
}
