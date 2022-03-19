package decorator;

import objects.items.Arme;

    public class EpeeBois extends DecorateurArme {

        int addAtk;
        public EpeeBois(Arme arme, int addAtk)
        {
            super.arme=arme;
            this.addAtk = addAtk;
        }
        @Override
        public String getDescription() {
            return arme.getDescription() + "\nUne épée en bois, souvent utilisée pour s'entraîner. +" + this.getAddAtk() + " ATK !";
        }

        @Override
        public int getAddAtk() {
            return this.addAtk;
        }
        @Override
        public String toString() {
            return "Epee en bois";
        }

    }


