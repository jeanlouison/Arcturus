package model;

public class Arcturien extends Personnage {
    /**
     * @attribute
     * id de l'arcturien.
     */
    private Integer id;

    /**
     * @attribute
     * force de l'arcturien.
     */
    private static Integer force;

    /**
     * Constructeur
     * Attribue a l'arcturien l'id passe en parametre
     * @param id
     */
    public Arcturien(Integer id) {
        this.id = id;
    }

    /**
     * @return l'id de l'arcturien
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param force the force to set
     */
    public static void setForce(int force) {
        Arcturien.force = force;
    }

    /**
     * @return the force
     */
    public static int getForce() {
        return force;
    }

    /**
     * Renvoie le type du personnage sous forme de texte.
     * @return "Arcturien"
     */
    public String getType(){
        return "Arcturien";
    }

    /**
     * Renvoie des informations sur l'arcturien sous forme de texte.
     * @return informations sur l'arcturien.
     */
    @Override
    public String toString() {
        return "["+id+"] : "+this.getType()+" : "+this.getVie()+" PV, "+Arcturien.getForce()+" ATK.";
    }
}
