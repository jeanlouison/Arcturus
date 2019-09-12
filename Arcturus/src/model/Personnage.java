package model;

public abstract class Personnage {
    /**
     * @attribute
     */
    private Integer force;

    /**
     * @attribute
     */
    private Integer vie = 200;

    /**
     * @attribute
     */
    private Integer id;
    
    public Personnage(){
        
    }

    public void frapper(Personnage personnage) {
        
    }

    protected void recevoirCoup(Integer degats) {
        
    }

    public String toString() {
    }

    public Integer getVie() {
    }

    public Integer getId() {
    }
}
