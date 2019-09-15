package model;

public class Arme {

    /**
     * @attribute
     * puissance de l'arme.
     */
    private Integer puissance;

    /**
     * @attribute
     * id de l'arme.
     */
    private Integer id;

    /**
     * Constructeur
     * Attribue a l'arme son id passe en parametre
     * et sa puissance passee en parametre
     * @param id
     * @param puissance
     */
    public Arme(Integer id, Integer puissance) {
        this.id = id;
        this.puissance = puissance;
    }

    /**
     * @return the nextId
     */
    public Integer getId() {
        return id;
    }

    /**
     * Renvoie le type du personnage sous forme de texte.
     * @return "Arme"
     */
    public String getType() {
        return "Arme";
    }

    /**
     * @return the puissance
     */
    public Integer getPuissance() {
        return puissance;
    }

    /**
     * Donne des informations sur l'arme sous forme de texte.
     * @return informations sur l'arme.
     */
    @Override
    public String toString() {
        return "["+id+"] : "+this.getType()+" : Puissance : "+puissance+".";
    }
}
