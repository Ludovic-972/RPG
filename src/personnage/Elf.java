package personnage;

public class Elf extends Joueur {

    private Specialite specialite; //magique ou physique
    private String clan; // elf type nature ou elf noir (merci la mythologie nordique)

    public Elf(String name, int hp, int maxHp, int attackPoints, String clan){
        super(name, hp, maxHp, attackPoints);
        this.clan = clan;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public String getClan() {
        return clan;
    }


    @Override
    public void attack(Personage ennemi) {
        ennemi.receiveDamages(this.getAttackPoints());
    }
}
