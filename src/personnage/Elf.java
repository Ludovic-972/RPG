package personnage;

public class Elf extends Joueur {

    private Specialite specialite; //magique ou physique
    private String clan; // elf type nature ou elf noir (merci la mythologie nordique)

    public Elf(String name, int hp, int maxHp, int attackPoints, String clan, Specialite specialite){
        super(name, hp, maxHp, attackPoints);
        this.clan = clan;
        this.specialite = specialite;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public String getClan() {
        return clan;
    }


}
