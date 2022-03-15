package factory;

import personnage.Elf;
import personnage.Humain;
import personnage.Joueur;

public class JoueurFactory extends JoueurFactoryAbstract{
    private Joueur factoryJoueur;
    private String nom;
    private int hp;
    private int level;
    private int xpNeed;
    private int maxHp;
    private int attackPoints;
    private String clan;

    @Override
    public Joueur creerJoueur(String nomClasse) {
        switch (nomClasse){
            case "Humain":
                return factoryJoueur = new Humain(nom, hp, level, xpNeed, maxHp, attackPoints);
            case "Elf":
                return factoryJoueur = new Elf(nom, hp, level, xpNeed, maxHp, attackPoints, clan);
        }
        return null;
    }
}
