package factory;

import personnage.Ennemi;
import personnage.TypeElement;
import personnage.TypeMonstre;

public abstract class EnnemiFactoryAbstract {
    public abstract Ennemi creerEnnemi(String nomClasse, String nom, TypeMonstre type);
}
