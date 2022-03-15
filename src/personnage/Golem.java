package personnage;

import objects.items.Item;
import objects.items.Materiaux;
import objects.items.TypeMateriaux;

import java.util.ArrayList;
import java.util.List;

public class Golem extends  Ennemi{
    private List<Item> items;
    private TypeMonstre type;
    private TypeElement typeElem;
    private Materiaux materiauBase;

    public Golem(String name, int hp, int maxHp, int attackPoints, TypeMonstre type, TypeElement typeElem, int XP) {
        super(name, hp, maxHp, attackPoints, XP);
        items = new ArrayList<>();
        materiauBase = new Materiaux(TypeMateriaux.MORCEAU_DE_PIERRE);
        items.add(materiauBase);
        this.type = type;
        this.typeElem = typeElem;
    }

    public Golem(String name, TypeMonstre type, TypeElement typeElem)
    {
        super(name);
        this.items = new ArrayList<>();
        this.materiauBase = new Materiaux(TypeMateriaux.COEUR_DE_GOLEM);
        items.add(materiauBase);
        this.type = type;
        this.typeElem = typeElem;
        this.setItems(items);
        this.setHp(500);
        this.setMaxHp(500);
        this.setXP(100);
        this.setAttackPoints(80);
    }


    public TypeElement getTypeElem() {
        return typeElem;
    }

    public Item typeOrbe(){
        Item item;
        switch (this.typeElem){
            case EAU:
                item = new Materiaux(TypeMateriaux.ORBE_D_EAU);
                return item;
            case FEU:
                item = new Materiaux(TypeMateriaux.ORBE_DE_FEU);
                return item;
            case VENT:
                item = new Materiaux(TypeMateriaux.ORBE_DE_VENT);
                return item;
            case GLACE:
                item = new Materiaux(TypeMateriaux.ORBE_DE_GLACE);
                return item;
            case TERRE:
                item = new Materiaux(TypeMateriaux.ORBE_DE_TERRE);
                return item;
            case LUMIERE:
                item = new Materiaux(TypeMateriaux.ORBE_DE_LUMIERE);
                return item;
            case TENEBRE:
                item = new Materiaux(TypeMateriaux.ORBE_DE_TENEBRE);
                return item;
            case ELECTRICITE:
                item = new Materiaux(TypeMateriaux.ORBE_DE_FOUDRE);
                return item;
        }
        return null;
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
