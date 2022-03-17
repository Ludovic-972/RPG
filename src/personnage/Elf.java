package personnage;

import strategie.AttaquerDistance;

public class Elf extends Joueur {
    public Elf(String name, int hp, int level, int XPNeeded, int maxHp, int attackPoints){
        super(name, level ,XPNeeded, hp, maxHp, attackPoints);
        this.attaquer = new AttaquerDistance();
    }

    @Override
    public void attack(Personage ennemi) {

    }
}
