import personnage.Elf;
import personnage.Humain;
import personnage.Joueur;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("test");
    Scanner clavier = new Scanner(System.in);
    System.out.println("Choisissez une classe : \n1.Elf \n2.Humain");
    int choixClasse = clavier.nextInt();

    switch(choixClasse)
    {
        case 1:
            System.out.println("Choisissez un nom : ");
            String nomClasse = clavier.next();
            System.out.println("Choisissez un nom de clan : ");
            String nomClan = clavier.next();
            Joueur j1 = new Elf(nomClasse, 15,15,5,nomClan);
            System.out.println("Vous avez crée : \nRace : Elf \nNom : " + j1.getName() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints() + "\nNom du clan : " + nomClan);
            break;
        case 2:
            System.out.println("Choisissez un nom : ");
            String nomClasse2 = clavier.next();
            Joueur j2 = new Humain(nomClasse2, 15,15,5);
            System.out.println("Vous avez crée \nRace : Humain \nNom : " + j2.getName() + "\nHP : " + j2.getHp() + "/" + j2.getMaxHp() + "\nATK : " + j2.getAttackPoints());
            break;
        default:
            System.out.println("Choissez une race valide");
            break;

    }
    }
}
