import objects.items.Arme;
import objects.items.Item;
import objects.items.Potion;
import personnage.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Joueur j1 = null;
    static Ennemi ennemi = null;
    static String nomClasse;
    static String nomClan;
    static int choixClasse;
    static int choixAction;
    static boolean inFight;
    static Scanner clavier;
    public static void main(String[] args) {


        clavier = new Scanner(System.in);
        System.out.println("Choisissez une classe : \n1.Elf \n2.Humain");
        boolean validInput = false;
        while(validInput == false) {
            choixClasse = clavier.nextInt();
            switch (choixClasse) {
                case 1:
                    createElfChar();
                    validInput = true;
                    break;
                case 2:
                    createHumanChar();
                    validInput = true;
                    break;
                default:
                    System.out.println("Choisissez une race valide");
                    break;
            }
        }
        Item potion = new Potion();
        Item arme = new Arme();
        for(int i = 0; i < 5; i++)
        {
            j1.getLeSac().add(potion);
        }
        j1.getLeSac().add(arme);
        while(true) {
            System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Affronter un monstre \n3.Afficher vos stats");
            boolean validInput2 = false;
            while (validInput2 == false) {
                choixAction = clavier.nextInt();
                switch (choixAction) {
                    case 1:
                        showBag();
                        validInput2 = true;

                        break;
                    case 2:
                        System.out.println("Choisissez une difficultée : \n1.Bas niveau \n2.Haut niveau \n3.Boss");
                        validInput2 = true;
                        choixAction = clavier.nextInt();
                        switch (choixAction) {
                            case 1:
                                startLowLevelFight();
                                break;
                            case 2:
                                startHighLevelFight();
                                break;
                            case 3:
                                startBossFight();
                                break;
                        }
                        break;
                    case 3:
                        validInput2 = true;
                        System.out.println("Nom : " + j1.getName() + "\nNiveau : " + j1.getLevel() + "\nXP : " + j1.getXp() + "/" + j1.getXpNeeded() + "\nHP : " + j1.getHp()
                                + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints());
                        break;

                }
            }
        }
    }

    private static void showBag()
    {
        System.out.println(j1.getLeSac().toString());
    }
    private static void createHumanChar() {
        System.out.println("Choisissez un nom : ");
        nomClasse = clavier.next();
        j1 = new Humain(nomClasse, 15, 1, 10, 15, 5);
        System.out.println("Vous avez crée \nRace : Humain \nNom : " + j1.getName() + "\nNiveau : " + j1.getLevel() + "\nXP : " + j1.getXp() + "/" + j1.getXpNeeded() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints());
    }

    private static void createElfChar() {
        System.out.println("Choisissez un nom : ");
        nomClasse = clavier.next();
        System.out.println("Choisissez un nom de clan : ");
        nomClan = clavier.next();
        j1 = new Elf(nomClasse, 15, 1, 10, 15, 5, nomClan);
        System.out.println("Vous avez crée \nRace : Elf \nNom : " + j1.getName() + "\nNiveau : " + j1.getLevel() + "\nXP : " + j1.getXp() + "/" + j1.getXpNeeded() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints());
    }

    private static void startBossFight() {
        // Créer boss fight Golem
    }

    private static void startHighLevelFight() {
        int lowLevelFight = (int)(Math.random() * ((2 - 0) + 1)) + 0;
        switch(lowLevelFight) {
            case 0:
                ennemi = new Slime("Slimy", TypeMonstre.HAUTNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    System.out.println(j1.getName() + "                              " + ennemi.getName()
                            + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + ennemi.getHp() + "/" + ennemi.getMaxHp()
                            + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + ennemi.getAttackPoints());
                    System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
                    fightActions();
                }
                break;
            case 1:
                ennemi = new Bat("Battler", TypeMonstre.HAUTNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    System.out.println(j1.getName() + "                              " + ennemi.getName()
                            + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + ennemi.getHp() + "/" + ennemi.getMaxHp()
                            + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + ennemi.getAttackPoints());
                    System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
                    fightActions();
                }
                break;
            case 2:
                ennemi = new Orc("Orkhas", TypeMonstre.HAUTNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    System.out.println(j1.getName() + "                              " + ennemi.getName()
                            + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + ennemi.getHp() + "/" + ennemi.getMaxHp()
                            + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + ennemi.getAttackPoints());
                    System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
                    fightActions();
                }
                break;
            default:
                break;
        }

    }

    private static void startLowLevelFight() {
        int lowLevelFight = (int)(Math.random() * ((2 - 0) + 1)) + 0;
        switch(lowLevelFight) {
            case 0:
                ennemi = new Slime("Slimy", TypeMonstre.BASNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    System.out.println(j1.getName() + "                              " + ennemi.getName()
                            + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + ennemi.getHp() + "/" + ennemi.getMaxHp()
                            + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + ennemi.getAttackPoints());
                    System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
                    fightActions();
                }
                break;
            case 1:
                ennemi = new Bat("Battler", TypeMonstre.BASNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    System.out.println(j1.getName() + "                              " + ennemi.getName()
                            + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + ennemi.getHp() + "/" + ennemi.getMaxHp()
                            + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + ennemi.getAttackPoints());
                    System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
                    fightActions();
                }
                break;
            case 2:
                ennemi = new Orc("Orkhas", TypeMonstre.BASNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    System.out.println(j1.getName() + "                              " + ennemi.getName()
                            + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + ennemi.getHp() + "/" + ennemi.getMaxHp()
                            + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + ennemi.getAttackPoints());
                    System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
                    fightActions();
                }
                break;
            default:
                break;
        }
                }


    private static void fightActions() {
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
                    j1.attack(ennemi);
                    if (ennemi.getHp() <= 0) {
                        break;
                    }
                    ennemi.attack(j1);
                    break;

            }
            endFight();

            }
        }

    private static void endFight() {
        if (ennemi.getHp() <= 0) {
            System.out.println(ennemi.getName() + " a été vaincu(e) ! ");
            j1.addExperience(ennemi);
            if(ennemi.getItems() != null) {
                for (int i = 0; i < ennemi.getItems().size(); i++) {
                    j1.getLeSac().add(ennemi.getItems().get(i));

                }
            }
            if(j1.levelUp())
            {
                System.out.println("Vous passez au niveau supérieure !");
            }

            inFight = false;
        }
        if(j1.getHp() <= 0)
        {
            System.out.println("Vous avez été vaincu(e) !");
            j1.setHp(j1.getMaxHp());
            ennemi.setHp(ennemi.getMaxHp());
            inFight = false;

        }


    }
}








