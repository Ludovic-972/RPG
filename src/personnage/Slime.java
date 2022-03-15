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
        this.setItems(items);
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
                this.setXP(1);
                break;
            case HAUTNIVEAU:
                this.setHp(40);
                this.setAttackPoints(5);
                this.setMaxHp(40);
                this.setXP(5);
                break;
            case BOSS:
                this.setHp(200);
                this.setAttackPoints(20);
                this.setMaxHp(40);
                this.setXP(50);
                break;

        }
    }

}
