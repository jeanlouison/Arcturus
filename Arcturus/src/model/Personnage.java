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
        return "["+id+"] : "+vie+" PV, "+force+" ATK.";
    }

   /**
    * @return the vie
    */
   public Integer getVie() {
       return vie;
   }

   /**
    * @return the id
    */
   public Integer getId() {
       return id;
   }
}
