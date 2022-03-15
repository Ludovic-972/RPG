package factory;

import personnage.Elf;
import personnage.Humain;
import personnage.Joueur;

public class JoueurFactory extends JoueurFactoryAbstract{
    private Joueur factoryJoueur;


    @Override
    public Joueur creerJoueur(String nomClasse, String nomPerso, int hp, int level, int XPNeeded, int maxHp, int attackPoints) {
        switch (nomClasse){
            case "Humain":
                return factoryJoueur = new Humain(nomPerso, hp, level, XPNeeded, maxHp, attackPoints);
            case "Elf":
                return factoryJoueur = new Elf(nomPerso, hp, level, XPNeeded, maxHp, attackPoints);
            default:
                return null;
        }
    }
}
