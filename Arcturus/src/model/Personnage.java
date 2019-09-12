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
    private String type;

    /**
     * @attribute
     */
    protected Integer id;

    public void frapper(Personnage personnage) {
        
    }

    protected void recevoirCoup(Integer degats) {
        
    }

    @Override
    public String toString() {
        return "["+id+"] : "+type+" : "+vie+" PV, "+force+" ATK.";
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

   /**
    * @return the type
    */
   public String getType() {
       return type;
   }
}
