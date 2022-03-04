package objects.items;


import objects.sac.Stackable;

public class Potion extends Item implements Stackable {

    @Override
    public String toString() {
        return "Potion";
    }

    @Override
    public String getItemType() {
        return "Potion";
    }
}
