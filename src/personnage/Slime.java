package personnage;

import objects.items.Item;
import objects.items.Materiaux;
import objects.items.TypeMateriaux;

import java.util.ArrayList;
import java.util.List;

public class Slime extends Ennemi{
    private List<Item> items;
    private Materiaux materiauBase;
    private TypeMonstre type;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Materiaux getMateriauBase() {
        return materiauBase;
    }

    public void setMateriauBase(Materiaux materiauBase) {
        this.materiauBase = materiauBase;
    }

    public TypeMonstre getType() {
        return type;
    }

    public void setType(TypeMonstre type) {
        this.type = type;
    }

    public Slime(String name, TypeMonstre type) {
        super(name);
        this.items = new ArrayList<>();
        this.materiauBase = new Materiaux(TypeMateriaux.SLIME_BALL);
        items.add(materiauBase);
        this.type = type;
        setStats();

    }

    public void setStats()
    {
        switch(type)
        {
            case BASNIVEAU:
                this.setHp(20);
                this.setAttackPoints(1);
                this.setMaxHp(20);
                break;
            case HAUTNIVEAU:
                this.setHp(40);
                this.setAttackPoints(5);
                this.setMaxHp(40);
                break;
            case BOSS:
                this.setHp(200);
                this.setAttackPoints(20);
                this.setMaxHp(40);
                break;

        }
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
