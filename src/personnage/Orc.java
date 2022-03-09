package personnage;

import objects.items.Item;
import objects.items.Materiaux;
import objects.items.TypeMateriaux;
import objects.sac.Sac;

import java.util.ArrayList;
import java.util.List;

public class Orc extends Ennemi {

    private TypeMonstre type;
    private List<Item> items;
    private Materiaux materiauBase;

    public Orc(String name, int hp, int maxHp, int attackPoints, TypeMonstre type) {
        super(name, hp, maxHp, attackPoints);
        this.items = new ArrayList<>();
        this.materiauBase = new Materiaux(TypeMateriaux.CROC);
        items.add(materiauBase);
        this.type = type;
    }

    public boolean dropItem(List<Item> items){
        if (!items.isEmpty()){
            System.out.println(getName() + " laisse tomber " + items.toString() + ".");
            return true;
        }
        System.out.println(getName() + " ne laisse tomber aucun item.");
        return false;
    }
}
