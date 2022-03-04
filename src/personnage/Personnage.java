package personnage;

public abstract class Personnage {
	private String name;
    private int hp;
    private int maxHp;
    private int attackPoints;
    
    public Personnage() {
    	
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
        ennemi.receiveDamages(this.attackPoints);
    }

    public void receiveDamages(int damages){
        this.hp = this.hp-damages;
    }


}
