package objects.items;

public abstract class Item {

    public abstract String getItemType();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Item) {
            Item item = (Item) obj;
            return this.getItemType().equals(((Item) obj).getItemType());
        }
        return false;
    }
}
