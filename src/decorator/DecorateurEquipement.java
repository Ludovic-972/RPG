package decorator;

import objects.items.Armure;
import personnage.Joueur;
import personnage.Personage;

public abstract class DecorateurEquipement extends Armure {
    protected Armure armure;
    public abstract String getDescription();
    public abstract int getAddHp();

}
