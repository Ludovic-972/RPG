package personnage;

public abstract class Joueur implements Personnage {
    private String name;
    private int hp;
    private int maxHp;
    private int attackPoints;

    public Joueur(String name, int hp, int maxHp, int attackPoints){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attackPoints = attackPoints;
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

    public void attack(Personnage ennemi){
        ennemi.receiveDamages(getAttackPoints());
    }

    public void receiveDamages(int damages){
        this.hp = this.hp-damages;
        if(getHp() == 0){
            System.out.println("Vous avez été vaincu");
        } else {
            System.out.println("Il reste " + getHp() + "point(s) de vie");
        }
    }

}
