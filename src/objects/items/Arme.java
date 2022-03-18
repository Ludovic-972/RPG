package objects.items;

public class Arme extends Item{
    String description;
    int addAtk;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAddAtk() {
        return addAtk;
    }

    public void setAddAtk(int addAtk) {
        this.addAtk = addAtk;
    }

    public Arme()
    {
        this.description = "Liste d'armes : ";
    }
    @Override
    public String toString() {
        return "Arme";
    }

    @Override
    public String getItemType() {
        return "Arme";
    }
}
