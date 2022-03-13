package factory;

import personnage.Ennemi;

public abstract class EnnemiFactoryAbstract {
    public abstract Ennemi creerEnnemi(String nomClasse);
}
