package personnage;

public class Humain extends Joueur {
    public Humain(String name, int hp, int maxHp, int attackPoints){
       super(name, hp, maxHp, attackPoints);
    }

    @Override
    public void attack(Ennemi ennemi) {

    }
}
