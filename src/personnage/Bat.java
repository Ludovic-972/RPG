package personnage;

import objects.items.Item;
import objects.items.Materiaux;
import objects.items.TypeMateriaux;

import java.util.ArrayList;
import java.util.List;

public class Bat extends Ennemi{
    private List<Item> items;
    private Materiaux materiauBase;
    private TypeMonstre type;

    public Bat(String name, TypeMonstre type) {
        super(name);
        this.items = new ArrayList<>();
        this.materiauBase = new Materiaux(TypeMateriaux.AILE);
        items.add(materiauBase);
        this.setItems(items);
        this.type = type;
        setStats();

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


    public void setStats()
    {
        switch(type)
        {
            case BASNIVEAU:
                this.setHp(15);
                this.setAttackPoints(2);
                this.setMaxHp(15);
                this.setXP(2);
                break;
            case HAUTNIVEAU:
                this.setHp(30);
                this.setAttackPoints(10);
                this.setMaxHp(30);
                this.setXP(8);
                break;
            case BOSS:
                this.setHp(150);
                this.setAttackPoints(30);
                this.setMaxHp(150);
                this.setXP(50);
                break;

        }
    }
}
