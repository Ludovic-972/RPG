package personnage;

public abstract class Ennemi implements Personage {
    private String name;
    private int hp;
    private int maxHp;
    private int attackPoints;

    public Ennemi(String name, int hp, int maxHp, int attackPoints){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attackPoints = attackPoints;
    }

    public Ennemi(String name) {
        this.name = name;
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

    @Override
    public void attack(Personage ennemi) {
        ennemi.receiveDamages(this.getAttackPoints());
    }

    @Override
    public void receiveDamages(int damage) {
        this.hp = this.hp-damage;

    }
}
