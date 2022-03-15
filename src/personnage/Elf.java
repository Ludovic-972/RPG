package personnage;

public class Elf extends Joueur {


    public Elf(String name, int hp, int level, int XPNeeded, int maxHp, int attackPoints){
        super(name, level ,XPNeeded, hp, maxHp, attackPoints);
    }



    @Override
    public void attack(Personage ennemi) {
        ennemi.receiveDamages(this.getAttackPoints());
    }
}
