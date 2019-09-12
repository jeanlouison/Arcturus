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
}