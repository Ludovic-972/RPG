package personnage;

public abstract class Ennemi implements Personnage{
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


}
