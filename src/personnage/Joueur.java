package personnage;

import objects.sac.Sac;

public abstract class Joueur implements Personage {
    private String name;
    private int hp;
    private int maxHp;
    private int attackPoints;
    private Sac leSac;
    private int xp;
    private int xpNeeded;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpNeeded() {
        return xpNeeded;
    }

    public void setXpNeeded(int xpNeeded) {
        this.xpNeeded = xpNeeded;
    }

    private Ennemi ennemi;

    public Sac getLeSac() {
        return leSac;
    }

    public void setLeSac(Sac leSac) {
        this.leSac = leSac;
    }

    public Joueur(String name,int level, int XPNeeded, int hp, int maxHp, int attackPoints){
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.xpNeeded = XPNeeded;
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

    public void addExperience(Ennemi ennemi) {
        this.ennemi = ennemi;
        this.xp += ennemi.getXP();
    }

    public boolean levelUp()
    {
        if(xp >= xpNeeded) {
            if (getLevel() != 99)
                setLevel(getLevel() + 1);
                setXp(0);
                return true;
        }
        return false;
    }
}
