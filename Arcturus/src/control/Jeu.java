import java.util.ArrayList;

import model.*;

public class Jeu {

    /**
     * @attribute
     */
    private static int nextTerrienId;

    /**
     * @attribute
     */
    private static int nextArcturienId;

    /**
     * @attribute
     */
    private static int nextArmeId;


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

    public Jeu(Integer fdb_terrien, Integer force_arcturien) {
        Terrien.setFORCE_DE_BASE(fdb_terrien);
        Arcturien.setFORCE(force_arcturien);
    }

    public int creerArcturien(){
        Arcturien newArcturien = new Arcturien(Jeu.nextArcturienId);
        listeArcturiens.add(newArcturien);
        Jeu.nextArcturienId++;
        return newArcturien.getId();
    }

    public int creerTerrien(){
        Terrien newTerrien = new Terrien(Jeu.nextTerrienId);
        listeTerriens.add(newTerrien);
        Jeu.nextTerrienId++;
        return newTerrien.getId();
    }

    public int creerArme(Integer puissance){
        Arme newArme = new Arme(Jeu.nextArmeId);
        listeArmes.add(newArme);
        Jeu.nextArmeId++;
        return newArme.getId();
    }

    public static void donnerArme(Integer terrien, Integer arme){
        terrien.recevoirArme(arme);
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

    public static String terrienFrappeArcturien(Integer idTerrien, Integer idArcturien){
        String res = "";
        Terrien t = null;
        Arcturien a; 

        if (getTerrien(idTerrien) != null && getArcturien(idArcturien) != null) {
            //les deux existent, on attaque
            Integer dmg = getTerrien(idTerrien).getDamageOutput();

            //pas fini

            res = idTerrien+" attaque "+idArcturien+" pour "+dmg+" dmg.";
        }
        else if (getTerrien(idTerrien) == null){
            res += "ERR : Le terrien n'existe pas.\n";
        }
        else if (getArcturien(idArcturien) == null){
            res += "ERR : L'arcturien n'existe pas.\n";
        }

        return res;
    }

    public static String arcturienFrappeTerrien(Integer idTerrien, Integer idArcturien){

    }
}