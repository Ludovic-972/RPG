package factory;

import personnage.Joueur;

public abstract class JoueurFactoryAbstract {

    public abstract Joueur creerJoueur(String nomClasse, String nomPerso, int hp, int level, int XPNeeded, int maxHp, int attackPoints);
}
