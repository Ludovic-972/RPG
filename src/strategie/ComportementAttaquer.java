package strategie;

import personnage.Ennemi;
import personnage.Personage;

public interface ComportementAttaquer {
    public abstract void attack(Ennemi ennemi, int damage);
}
