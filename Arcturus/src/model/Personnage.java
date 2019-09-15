package model;

public abstract class Personnage {

    /**
     * @attribute
     * vie du personnage
     */
    private Integer vie = 200;

    /**
     * @attribute
     * id du personnage
     */
    protected Integer id;

    /**
     * enleve des points de vie du personnage en fonction des degats passes en parametre.
     * @param degats
     */
    public void recevoirCoup(Integer degats) {
        this.vie -= degats;
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
       return "Personnage";
   }
}
