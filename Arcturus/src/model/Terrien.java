package model;

import java.util.ArrayList;

public class Terrien extends Personnage {
    
    /**
     * @attribute
     */
    private static int FORCE_DE_BASE;

    /**
     * @attribute
     */
    private ArrayList<Arme> listeArmes = new ArrayList<Arme>();

    public Terrien(Integer id) {
        this.id = id;
    }

    public void recevoirArme(Arme arme) {
        this.listeArmes.add(arme);
    }

    /**
     * @param FORCE_DE_BASE the FORCE_DE_BASE to set
     */
    public static void setFORCE_DE_BASE(int forceDeBase) {
        Terrien.FORCE_DE_BASE = forceDeBase;
    }

    public String getType(){
        return "Terrien";
    }

    public Integer getDamageOutput(){
        Integer dmg = FORCE_DE_BASE;
        for (Arme arme : listeArmes) {
            dmg += arme.getPuissance();
        }
        return dmg;
    }

    @Override
    public String toString() {
        return "["+id+"] : "+this.getType()+" : "+this.getVie()+" PV, "+this.getDamageOutput()+" ATK.";
    }
}
