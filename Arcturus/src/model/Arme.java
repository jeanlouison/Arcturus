package model;

public class Arme {
    /**
     * @attribute
     */
    private Integer puissance;

    /**
     * @attribute
     */
    private Integer id;

    /**
     * @attribute
     */
    private String type = "Arme";

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

    public String getType() {
        return "Arme";
    }

    /**
     * @return the puissance
     */
    public Integer getPuissance() {
        return puissance;
    }

    @Override
    public String toString() {
        return "["+id+"] : "+type+" : Puissance : "+puissance+".";
    }
}
