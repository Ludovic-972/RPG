package strategie;

import factory.JoueurFactory;
import personnage.Ennemi;
import personnage.Humain;
import personnage.Joueur;
import personnage.Personage;

public class AttaquerEpee implements ComportementAttaquer{

    //si le joueur a une épée, il attaque avec une épée.
    @Override
    public void attack(Ennemi ennemi, int damage) {
        System.out.println(ennemi.getName().toString() + " reçoit votre coup d'épée");
        ennemi.receiveDamages(damage);
    }
}
