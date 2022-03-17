package strategie;

import personnage.Ennemi;

public class AttaquerDistance implements ComportementAttaquer{
    private int damage;
    @Override
    public void attack(Ennemi ennemi, int damage) {
        System.out.println(ennemi.getName().toString() + " a été touché par votre flèche.");
        ennemi.receiveDamages(damage);
    }
}
