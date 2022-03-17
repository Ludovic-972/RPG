package personnage;

import strategie.AttaquerEpee;

public class Humain extends Joueur {
    public Humain(String name, int hp, int level, int XPNeeded, int maxHp, int attackPoints){
        super(name, level ,XPNeeded, hp, maxHp, attackPoints);
        this.attaquer = new AttaquerEpee();
    }

    public Humain(){
        //constructeur par defaut
    }

    @Override
    public void attack(Personage ennemi) {
        ennemi.receiveDamages(this.getAttackPoints());
    }
}
