package factory;

import personnage.Joueur;

public abstract class JoueurFactoryAbstract {
    public abstract Joueur creerJoueur(String nomClasse);
}
