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



    public Orc(String name, TypeMonstre type) {
        super(name);
        this.items = new ArrayList<>();
        this.materiauBase = new Materiaux(TypeMateriaux.CROC);
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
                this.setHp(10);
                this.setAttackPoints(3);
                this.setMaxHp(10);
                this.setXP(3);
                break;
            case HAUTNIVEAU:
                this.setHp(25);
                this.setAttackPoints(8);
                this.setMaxHp(30);
                this.setXP(15);
                break;
            case BOSS:
                this.setHp(120);
                this.setAttackPoints(40);
                this.setMaxHp(150);
                this.setXP(60);
                break;

        }
    }

}
