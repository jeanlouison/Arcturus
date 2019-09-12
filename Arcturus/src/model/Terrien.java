package model;

import java.util.ArrayList;

public class Terrien extends Personnage {
    /**
     * @attribute
     */
    private static Integer forceDeBase;

    /**
     * @attribute
     */
    private static Integer nextId;

    /**
     * @attribute
     */
    private ArrayList<Arme> listeArmes = new ArrayList()<Arme>;

    public void recevoirArme(Arme arme) {
        listeArmes.add(arme);
    }

    /**
     * @return the nextId
     */
    public static Integer getNextId() {
        return nextId;
    }
}
