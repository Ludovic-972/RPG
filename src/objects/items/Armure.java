package objects.items;

public class Armure extends Item{

    String description;
    int addHp;

    public Armure()
    {
        this.description = "Liste d'armures : ";
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getAddHp() {
        return this.addHp;
    }

    public void setAddHp(int addHp) {
        this.addHp = addHp;
    }

    public String getDescription()
    {
        return this.description;
    }

    @Override
    public String getItemType() {
        return "Armure";
    }
    @Override
    public String toString() {
        return "Armure";
    }

}
