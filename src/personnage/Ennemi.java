package personnage;

import objects.items.Item;

import java.util.List;

public abstract class Ennemi implements Personage {
    private String name;
    private List<Item> items;
    private int hp;
    private int maxHp;
    private int attackPoints;
    private int XP;

    public Ennemi(String name, int hp, int maxHp, int attackPoints, int XP){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attackPoints = attackPoints;
        this.XP = XP;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
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

    public List<Item> getItems() {
        return items;
    }

    public int getDroppedXP() {
        return XP;
    }
}
