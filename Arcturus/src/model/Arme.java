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
    private static Integer nextId;

    /**
     * @return the nextId
     */
    public static Integer getNextId() {
        return nextId;
    }
}
