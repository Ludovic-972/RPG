package decorator;

import objects.items.Arme;

public class EpeeRouille extends DecorateurArme {

    int addAtk;
    public EpeeRouille(Arme arme, int addAtk)
    {
        super.arme=arme;
        this.addAtk = addAtk;
    }
    @Override
    public String getDescription() {
        return arme.getDescription() + "\nUne épée rouillée, pas très efficace mais fait toujours l'affaire. +" + this.getAddAtk() + " ATK !";
    }

    @Override
    public int getAddAtk() {
        return this.addAtk;
    }
    @Override
    public String toString() {
        return "Epee rouillée";
    }

}


