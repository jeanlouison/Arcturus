package model;

import java.util.ArrayList;

public class Terrien extends Personnage {
    
    /**
     * @attribute
     * force de base du terrien, initialisee avec la fonction init() de {@link control.Jeu},
     * a laquelle s'ajoute les degats des armes que possede le terrien.
     * Commune a tous les terriens.
     */
    private static int FORCE_DE_BASE;

    /**
     * @attribute
     * liste des armes que possede le terrien.
     */
    private ArrayList<Arme> listeArmes = new ArrayList<Arme>();

    /**
     * Constructeur,
     * Attribue l'id passe en parametre.
     * @param id
     */
    public Terrien(Integer id) {
        this.id = id;
    }

    /**
     * Ajoute l'arme passee en parametre a la liste des armes du terrien.
     * @param arme
     */
    public void recevoirArme(Arme arme) {
        this.listeArmes.add(arme);
    }

    /**
     * @param FORCE_DE_BASE the FORCE_DE_BASE to set
     */
    public static void setFORCE_DE_BASE(int forceDeBase) {
        Terrien.FORCE_DE_BASE = forceDeBase;
    }

    /**
     * Renvoie le type du personnage sous forme de texte.
     * @return "Terrien"
     */
    public String getType(){
        return "Terrien";
    }

    /**
     * Calcule les degats totaux que le terrien inflige avec ses armes
     * @return force totale
     */
    public Integer getDamageOutput(){
        Integer dmg = FORCE_DE_BASE;
        for (Arme arme : listeArmes) {
            dmg += arme.getPuissance();
        }
        return dmg;
    }

    /**
     * Renvoie des informations sur le terrien sous forme de texte.
     * @return informations sur le terrien.
     */
    @Override
    public String toString() {
        return "["+id+"] : "+this.getType()+" : "+this.getVie()+" PV, "+this.getDamageOutput()+" ATK.";
    }
}
