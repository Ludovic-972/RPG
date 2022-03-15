package factory;

import personnage.*;

public class EnnemiFactory extends EnnemiFactoryAbstract{
    private Ennemi ennemiFactory;
    private String nom;
    private int hp;
    private int level;
    private int xp;
    private int maxHp;
    private int attackPoints;
    private TypeMonstre type;
    private TypeElement typeElem;
    @Override
    public Ennemi creerEnnemi(String nomClasse) {
        switch (nomClasse){
            case "Orc":
                return ennemiFactory = new Orc(nom, type);
            case "Bat":
                return ennemiFactory = new Bat(nom, type);
            case "Slime":
                return ennemiFactory = new Slime(nom, type);
            case "Golem":
                return ennemiFactory = new Golem(nom, type, typeElem);
        }
        return null;
    }
}
