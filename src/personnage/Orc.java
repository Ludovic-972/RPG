package personnage;

import objects.items.Item;
import objects.sac.Sac;

import java.util.ArrayList;
import java.util.List;

public class Orc extends Ennemi {

    private TypeMonstre type;
    private List<Item> items;
    public Orc(String name, int hp, int maxHp, int attackPoints, TypeMonstre type) {
        super(name, hp, maxHp, attackPoints);
        this.items = new ArrayList<>();

        this.type = type;
    }

    public boolean dropItem(List<Item> items){
        if (! items.isEmpty()){
            System.out.println(getName() + " laisse tomber " + items.toString() + ".");
            return true;
        }
        System.out.println(getName() + " ne laisse tomber aucun item.");
        return false;
    }
}
