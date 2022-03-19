import decorator.ArmureBois;
import decorator.CasqueBois;
import decorator.EpeeBois;
import decorator.EpeeRouille;
import factory.EnnemiFactory;
import factory.JoueurFactory;
import objects.items.*;
import personnage.*;
import singleton.LogSingleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Joueur j1 = null;
    static Ennemi ennemi = null;
    static String nomClasse;
    static String nomPerso;
    static int choixClasse;
    static int choixAction;
    static boolean inFight;
    static Scanner clavier;
    static EnnemiFactory ennemiFactory;
    static JoueurFactory joueurFactory;
    static Armure armure;
    static Arme arme;
    static boolean armorPresent;
    static boolean armePresent;
    static String affichageActions;
    static Chrono chrono;
    static int nbKilled;
    public static void main(String[] args) {
        chrono = new Chrono();
        chrono.start();
        ennemiFactory = new EnnemiFactory();
        joueurFactory = new JoueurFactory();
        arme = new Arme();
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

        while(true) {

            if(armorPresent)
            {
                affichageActions = "Choississez une action : \n1.Ouvrir le sac \n2.Affronter un monstre \n3.Afficher vos stats\n4.Equiper armure";
            }
            if(armePresent) {
                if(armorPresent) affichageActions += "\n5.Equiper arme";
                else affichageActions = "Choississez une action : \n1.Ouvrir le sac \n2.Affronter un monstre \n3.Afficher vos stats\n5.Equiper arme";
            }
            if(!armePresent && !armorPresent)
            {
                affichageActions = "Choississez une action : \n1.Ouvrir le sac \n2.Affronter un monstre \n3.Afficher vos stats";
            }
            System.out.println(affichageActions);
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
                        if(j1.getArme() != null) {
                        System.out.println(j1.getArme().getDescription());
                    }
                        if(j1.getArmure() != null) {
                            System.out.println(j1.getArmure().getDescription());
                        }
                        break;
                    case 4:
                        validInput2 = true;
                        if(armorPresent) {
                            for (int i = 0; i < j1.getLeSac().getSize(); i++) {
                                if (j1.getLeSac().get(i).getItem() instanceof Armure) {
                                    j1.equipArmure((Armure) j1.getLeSac().get(i).getItem());
                                    armorPresent = false;
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    case 5:
                        validInput2 = true;
                        if(armePresent) {
                            for (int i = 0; i < j1.getLeSac().getSize(); i++) {
                                if (j1.getLeSac().get(i).getItem() instanceof Arme) {
                                    j1.equipArme((Arme) j1.getLeSac().get(i).getItem());
                                    armePresent = false;
                                    break;
                                }
                            }
                            break;
                        }
                        break;


                }
            }
        }
    }

    private static void showBag()
    {
        System.out.println(j1.getLeSac().toString());
        for(int i = 0; i<j1.getLeSac().getSize(); i++)
        {
          if(j1.getLeSac().get(i).getItem() instanceof Armure)
          {
              armorPresent = true;
          }
          if(j1.getLeSac().get(i).getItem() instanceof Arme)
          {
              armePresent = true;
          }
        }

    }

    private static void createHumanChar() {
        nomClasse = "Humain";
        System.out.println("Choisissez un nom : ");
        nomPerso = clavier.next();
        j1 = joueurFactory.creerJoueur(nomClasse, nomPerso, 15, 1, 10, 15, 5);
        armure = new Armure();
        armure = new CasqueBois(armure, 2);
        j1.equipArmure(armure);
        System.out.println("Vous avez crée \nRace : Humain \nNom : " + j1.getName() + "\nNiveau : " + j1.getLevel() + "\nXP : " + j1.getXp() + "/" + j1.getXpNeeded() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints());
    }

    private static void createElfChar() {
        nomClasse = "Elf";
        System.out.println("Choisissez un nom : ");
        nomPerso = clavier.next();
        j1 = joueurFactory.creerJoueur(nomClasse, nomPerso, 15, 1, 10, 15, 5);
        armure = new Armure();
        armure = new CasqueBois(armure, 2);
        j1.equipArmure(armure);
        System.out.println("Vous avez crée \nRace : Elf \nNom : " + j1.getName() + "\nNiveau : " + j1.getLevel() + "\nXP : " + j1.getXp() + "/" + j1.getXpNeeded() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints());

    }



    private static void startBossFight() {
        // Créer boss fight Golem
        ennemi = ennemiFactory.creerEnnemi("Golem", "Goldmann", TypeMonstre.BOSS);
        System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
        inFight = true;
        while (inFight) {
            showBattle();
            fightActions();
        }

    }

    private static void startHighLevelFight() {
        int lowLevelFight = (int)(Math.random() * ((2 - 0) + 1)) + 0;
        switch(lowLevelFight) {
            case 0:
                ennemi = ennemiFactory.creerEnnemi("Slime", "Slimy", TypeMonstre.HAUTNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    showBattle();
                    fightActions();
                }
                break;
            case 1:

                ennemi = ennemiFactory.creerEnnemi("Bat", "Battler", TypeMonstre.HAUTNIVEAU);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    showBattle();
                    fightActions();
                }
                break;
            case 2:
                ennemi = ennemiFactory.creerEnnemi("Orc", "Orkhas", TypeMonstre.HAUTNIVEAU);
                arme = new EpeeRouille(arme, 8);
                ennemi.getItems().add(arme);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    showBattle();
                    fightActions();
                }
                break;
            default:
                break;
        }

    }

    private static void showBattle() {
        System.out.println(j1.getName() + "                              " + ennemi.getName()
                + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "                           HP : " + ennemi.getHp() + "/" + ennemi.getMaxHp()
                + "\nATK : " + j1.getAttackPoints() + "                             ATK : " + ennemi.getAttackPoints());
        System.out.println("Choississez une action : \n1.Ouvrir le sac \n2.Attaquer");
    }

    private static void startLowLevelFight() {
        int lowLevelFight = (int)(Math.random() * ((2 - 0) + 1)) + 0;
        switch(lowLevelFight) {
            case 0:
                ennemi = ennemiFactory.creerEnnemi("Slime", "Slimy", TypeMonstre.BASNIVEAU);
                armure = new ArmureBois(armure, 3);
                ennemi.getItems().add(armure);
                arme = new EpeeBois(arme, 2);
                ennemi.getItems().add(arme);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    showBattle();
                    fightActions();
                }
                break;
            case 1:
                ennemi = ennemiFactory.creerEnnemi("Bat", "Battler", TypeMonstre.BASNIVEAU);
                armure = new ArmureBois(armure, 3);
                ennemi.getItems().add(armure);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    showBattle();
                    fightActions();
                }
                break;
            case 2:
                ennemi = ennemiFactory.creerEnnemi("Orc", "Orkhas", TypeMonstre.BASNIVEAU);
                armure = new ArmureBois(armure, 3);
                ennemi.getItems().add(armure);
                System.out.println("Vous tombez nez à nez avec un " + ennemi.getClass().getName().substring(11));
                inFight = true;
                while (inFight) {
                    showBattle();
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
            nbKilled++;
            System.out.println(ennemi.getName() + " a été vaincu(e) ! ");
            System.out.println("Vous recevez " + ennemi.getXP() + " point(s) d'expérience !");

            j1.addExperience(ennemi);
            if(ennemi.getItems() != null) {
                System.out.println("Le " + ennemi.getName() + " laisse tomber : ");
                for (int i = 0; i < ennemi.getItems().size(); i++) {
                    System.out.println(ennemi.getItems().get(i));
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
            endGame();
        }


    }

    private static void endGame() {
        chrono.stop();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        LogSingleton log1 = LogSingleton.getInstance();
        LogSingleton log2 = LogSingleton.getInstance();
        LogSingleton log3 = LogSingleton.getInstance();
        log3.logTimeCreated(sdf.format(d));
        log1.logTimePlayed(chrono.getDureeTxt());
        log2.logCharacter(j1);
        log1.logSac(j1.getLeSac().toString());
        if(j1.getArme() != null) log3.logArme(j1.getArme().getDescription());
        if(j1.getArmure() != null)  log2.logArmure(j1.getArmure().getDescription());
        log1.logEnnemiesKilled(nbKilled);
        System.out.println("Un résumé de fin de partie est disponible dans le fichier statistiques_partie.txt.\nMerci d'avoir joué !");
        System.exit(0);
    }
}








