package singleton;

import personnage.Joueur;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogSingleton {
    private static LogSingleton logSingleton = null;

    public static synchronized LogSingleton getInstance(){
        if(logSingleton == null)
            logSingleton = new LogSingleton();
        return logSingleton;
    }

    private final String logFile = "statistiques_partie.txt";
    private PrintWriter writer;

    private LogSingleton() {
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {}
    }

    public void logCharacter(Joueur j1)
    {
        writer.println("Statistiques du joueur :  \nNom : " + j1.getName() + "\nNiveau : " + j1.getLevel() + "\nXP : " + j1.getXp() + "/" + j1.getXpNeeded() + "\nHP : " + j1.getHp() + "/" + j1.getMaxHp() + "\nATK : " + j1.getAttackPoints() + "\n");
    }


    public void logSac(String bagContent)
    {
        writer.println(bagContent);
    }

    public void logTimePlayed(String timePlayed)
    {
        writer.println("Temps joué : " + timePlayed);
    }
    public void logEnnemiesKilled(int nbKilled)
    {
        writer.println("Nombre d'ennemies vaincus : " + nbKilled);
    }


    public void logArme(String descriptionArme)
    {
        writer.println(descriptionArme + "\n");
    }
    public void logArmure(String descriptionArmure)
    {
        writer.println(descriptionArmure + "\n");
    }

    public void logTimeCreated(String format) {
        writer.println("Fichié crée le " + format + "\n");
    }
}