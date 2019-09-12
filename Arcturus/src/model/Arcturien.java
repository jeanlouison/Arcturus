package model;

public class Arcturien extends Personnage {
    /**
     * @attribute
     */
    private Integer id;

    /**
     * @attribute
     */
    private static int FORCE;

    public Arcturien(Integer id) {
        this.id = id;
    }

    /**
     * @return the nextId
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param FORCE the FORCE_DE_BASE to set
     */
    public static void setFORCE_DE_BASE(int force) {
        Arcturien.FORCE = force;
    }

    /**
     * @return the fORCE_DE_BASE
     */
    public static int getFORCE() {
        return FORCE;
    }

    public String getType(){
        return "Arcturien";
    }
}
