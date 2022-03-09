package personnage;

import objects.sac.Sac;

public abstract class Joueur implements Personage {
    private String name;
    private int hp;
    private int maxHp;
    private int attackPoints;
    private Sac leSac;

    public Sac getLeSac() {
        return leSac;
    }

    public void setLeSac(Sac leSac) {
        this.leSac = leSac;
    }

    public Joueur(String name, int hp, int maxHp, int attackPoints){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attackPoints = attackPoints;
        this.leSac = new Sac();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void attack(Ennemi ennemi){
        ennemi.receiveDamages(this.getAttackPoints());
    }

    public void receiveDamages(int damages){
        this.hp = this.hp-damages;

    }

}
