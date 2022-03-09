import objects.items.Arme;
import objects.items.Item;
import objects.items.Potion;
import personnage.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Joueur j1 = null;
    String nomClasse;
    String nomClan;
    int choixClasse;
    int choixAction;
    boolean inFight;
    Scanner clavier = new Scanner(System.in);
    System.out.println("Choisissez une classe : \n1.Elf \n2.Humain");
    boolean validInput = false;
    while(validInput == false) {
            choixClasse = clavier.nextInt();
        switch (choixClasse) {
            case 1:
                System.out.println("Choisissez un nom : ");
                nomClasse = clavier.next();
                System.out.println("Choisissez un nom de clan : ");
                nomClan = clavier.next();
                j1 = new Elf(nomClasse, 15, 15, 5, nomClan);
                System.out.println("Vous avez crée : \nRace : Elf \nNom : " + j1.getName() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints() + "\nNom du clan : " + nomClan);
                validInput = true;
                break;
            case 2:
                System.out.println("Choisissez un nom : ");
                nomClasse = clavier.next();
                j1 = new Humain(nomClasse, 15, 15, 5);
                System.out.println("Vous avez crée \nRace : Humain \nNom : " + j1.getName() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints());
                validInput = true;
                break;
            default:
                System.out.println("Choisissez une race valide");
        }
        Item potion = new Potion();
        Item arme = new Arme();
        for(int i = 0; i < 5; i++)
        {
            j1.getLeSac().add(potion);
        }
        j1.getLeSac().add(arme);
        while(true) {
            Ennemi slime = new Slime("Slimy", TypeMonstre.BASNIVEAU);
            System.out.println("Vous tombez nez à nez avec un " + slime.getClass().getName().substring(11));
            inFight = true;
            while (inFight) {
                System.out.println(j1.getName() + "                              " + slime.getName()
                        + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + slime.getHp() + "/" + slime.getMaxHp()
                        + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + slime.getAttackPoints());
                System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
                boolean validInput2 = false;
                while (validInput2 == false) {
                    choixAction = clavier.nextInt();
                    switch (choixAction) {
                        case 1:
                            System.out.println(j1.getLeSac().toString());
                            validInput2 = true;

                            break;
                        case 2:
                            validInput2 = true;
                            j1.attack(slime);
                            slime.attack(j1);
                            break;

                    }
                    if (slime.getHp() <= 0) {
                        System.out.println(slime.getName() + " a été vaincu(e) ! ");
                        for (int i = 0; i < ((Slime) slime).getItems().size(); i++) {
                            j1.getLeSac().add(((Slime) slime).getItems().get(i));
                        }
                        inFight = false;
                    }
                }
            }

        }

    }
    }



}
