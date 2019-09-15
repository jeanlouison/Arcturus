package control;

import java.util.ArrayList;
import model.*;

public class Jeu {

    /**
     * @attribute
     */
    private static Integer nextTerrienId = 0;

    /**
     * @attribute
     */
    private static Integer nextArcturienId = 0;

    /**
     * @attribute
     */
    private static Integer nextArmeId = 0;

    /**
     * @attribute
     */
    private static ArrayList<Arcturien> listeArcturiens = new ArrayList<Arcturien>();

    /**
     * @attribute
     */
    private static ArrayList<Arme> listeArmes = new ArrayList<Arme>();

    /**
     * @attribute
     */
    private static ArrayList<Terrien> listeTerriens = new ArrayList<Terrien>();

    public static void init(Integer forceTerrien, Integer forceArcturien) {
        Terrien.setFORCE_DE_BASE(forceTerrien);
        Arcturien.setFORCE(forceArcturien);
    }

    public static int creerArcturien(){
        Arcturien newArcturien = new Arcturien(Jeu.nextArcturienId);
        listeArcturiens.add(newArcturien);
        System.out.println("Arcturien "+nextArcturienId+" cree avec succes");
        Jeu.nextArcturienId++;
        return newArcturien.getId();
    }

    public static int creerTerrien(){
        Terrien newTerrien = new Terrien(Jeu.nextTerrienId);
        listeTerriens.add(newTerrien);
        System.out.println("Terrien "+nextTerrienId+" cree avec succes");
        Jeu.nextTerrienId++;
        return newTerrien.getId();
    }

    public static int creerArme(Integer puissance){
        Arme newArme = new Arme(Jeu.nextArmeId, puissance);
        listeArmes.add(newArme);
        System.out.println("Arme "+nextArmeId+" ("+puissance+" dmg) cree avec succes");
        Jeu.nextArmeId++;
        return newArme.getId();
    }

    public static void donnerArme(Integer terrien, Integer arme){
        String res = "";

        if (getTerrien(terrien) != null && getArme(arme) != null) {
            //les deux existent, on donne l'arme
            Jeu.getTerrien(terrien).recevoirArme(getArme(arme));
            res = terrien+" recoit l'arme "+arme+" pour un bonus de +"+getArme(arme).getPuissance()+" dmg.\n";
        }
        else if (getTerrien(terrien) == null){
            res += "ERR : Le terrien demande n'existe pas.\n";
        }
        else if (getArme(arme) == null){
            res += "ERR : L'arme demandee n'existe pas.\n";
        }

        System.out.println(res);
        
    }

    public static Terrien getTerrien(Integer id){
        Terrien t = null;
        for (Terrien tcheck : listeTerriens) {
            if (tcheck.getId() == id) {
                t = tcheck;
            }
        }
        return t;
    }

    public static Arcturien getArcturien(Integer id){
        Arcturien a = null;
        for (Arcturien acheck : listeArcturiens) {
            if (acheck.getId() == id) {
                a = acheck;
            }
        }
        return a;
    }
    
    public static Arme getArme(Integer id){
        Arme a = null;
        for (Arme acheck : listeArmes) {
            if (acheck.getId() == id) {
                a = acheck;
            }
        }
        return a;
    }

    public static void terrienFrappeArcturien(Integer idTerrien, Integer idArcturien){
        String res = "";

        if (getTerrien(idTerrien) != null && getArcturien(idArcturien) != null) {
            //les deux existent, on attaque
            Integer dmg = getTerrien(idTerrien).getDamageOutput();
            getArcturien(idArcturien).recevoirCoup(dmg);
            res = idTerrien+" attaque "+idArcturien+" pour "+dmg+" dmg.\n";
        }
        else if (getTerrien(idTerrien) == null){
            res += "ERR : Le terrien demande n'existe pas.\n";
        }
        else if (getArcturien(idArcturien) == null){
            res += "ERR : L'arcturien demande n'existe pas.\n";
        }

        System.out.println(res);
    }

    public static void arcturienFrappeTerrien(Integer idArcturien, Integer idTerrien){
        String res = "";

        if (getTerrien(idTerrien) != null && getArcturien(idArcturien) != null) {
            //les deux existent, on attaque
            Integer dmg = Arcturien.getFORCE();
            getTerrien(idTerrien).recevoirCoup(dmg);
            res = idArcturien+" attaque "+idTerrien+" pour "+dmg+" dmg.\n";
        }
        else if (getTerrien(idTerrien) == null){
            res += "ERR : Le terrien demande n'existe pas.\n";
        }
        else if (getArcturien(idArcturien) == null){
            res += "ERR : L'arcturien demande n'existe pas.\n";
        }

        System.out.println(res);
    }

    public static String infoTerrien(Integer idTerrien) {
        return getTerrien(idTerrien).toString();
    }

    public static String infoArme(Integer idArme) {
        return getArme(idArme).toString();
    }

    public static String infoArcturien(Integer idArcturien) {
        return getArcturien(idArcturien).toString();
    }

    public static String enumTerriens(){
        String res = "{ ";
        for (Terrien t : Jeu.listeTerriens) {
            if (t.getVie() > 0) {
                res += t.getId();
                res += " ";
            }
        }
        res += "}";
        return res;
    }

    public static String enumArmes(){
        String res = "{ ";
        for (Arme a : Jeu.listeArmes) {
            res += a.getId();
            res += " ";
        }
        res += "}";
        return res;
    }

    public static String enumArcturiens(){
        String res = "{ ";
        for (Arcturien a : Jeu.listeArcturiens) {
            if (a.getVie() > 0) {
                res += a.getId();
                res += " ";
            }
        }
        res += "}";
        return res;
    }
}