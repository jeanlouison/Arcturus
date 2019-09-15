package control;

import java.util.ArrayList;
import model.*;

public class Jeu {

    /**
     * @attribute
     * Id attribue au prochain terrien cree.
     */
    private static Integer nextTerrienId = 0;

    /**
     * @attribute
     * Id attribue au prochain arcturien cree.
     */
    private static Integer nextArcturienId = 0;

    /**
     * @attribute
     * Id attribue a la prochaine arme cree.
     */
    private static Integer nextArmeId = 0;

    /**
     * @attribute
     * Liste des arcturiens
     */
    private static ArrayList<Arcturien> listeArcturiens = new ArrayList<Arcturien>();

    /**
     * @attribute
     * Liste des armes
     */
    private static ArrayList<Arme> listeArmes = new ArrayList<Arme>();

    /**
     * @attribute
     * Liste des terriens
     */
    private static ArrayList<Terrien> listeTerriens = new ArrayList<Terrien>();

    /**
     * Fonction d'initialisation du jeu, qui definit les valeurs par defauts de la force des terriens et des arcturiens.
     * @param forceTerrien
     * @param forceArcturien
     */
    public static void init(Integer forceTerrien, Integer forceArcturien) {
        Terrien.setFORCE_DE_BASE(forceTerrien);
        Arcturien.setForce(forceArcturien);
    }

    /**
     * Instancie un nouvel arcturien et l'ajoute a la liste.
     * Imprime un message de succes et incremente l'id suivant.
     * @return id de l'arcturien cree
     */
    public static int creerArcturien(){
        Arcturien newArcturien = new Arcturien(Jeu.nextArcturienId);
        listeArcturiens.add(newArcturien);
        System.out.println("Arcturien "+nextArcturienId+" cree avec succes");
        Jeu.nextArcturienId++;
        return newArcturien.getId();
    }

    /**
     * Instancie un nouveau terrien et l'ajoute a la liste.
     * Imprime un message de succes et incremente l'id suivant.
     * @return id du terrien cree
     */
    public static int creerTerrien(){
        Terrien newTerrien = new Terrien(Jeu.nextTerrienId);
        listeTerriens.add(newTerrien);
        System.out.println("Terrien "+nextTerrienId+" cree avec succes");
        Jeu.nextTerrienId++;
        return newTerrien.getId();
    }

    /**
     * Instancie une nouvelle et l'ajoute a la liste.
     * Imprime un message de succes et incremente l'id suivant.
     * @return id de l'arme cree
     */
    public static int creerArme(Integer puissance){
        Arme newArme = new Arme(Jeu.nextArmeId, puissance);
        listeArmes.add(newArme);
        System.out.println("Arme "+nextArmeId+" ("+puissance+" dmg) cree avec succes");
        Jeu.nextArmeId++;
        return newArme.getId();
    }

    /**
     * Donne l'arme dont l'id est passee en parametre au terrien dont l'id est passe en parametre.
     * Affiche des messages de succes ou d'echec.
     * @param terrien
     * @param arme
     */
    public static void donnerArme(Integer terrien, Integer arme){
        String res = "";

        if (getTerrien(terrien) != null && getArme(arme) != null) {
            //les deux existent, on donne l'arme
            Jeu.getTerrien(terrien).recevoirArme(getArme(arme));
            res = terrien+" recoit l'arme "+arme+" pour un bonus de +"+getArme(arme).getPuissance()+" dmg.\n";
        }
        else if (getTerrien(terrien) == null){
            res += "ERR : Le terrien demande n'existe pas.\n";
        }
        else if (getArme(arme) == null){
            res += "ERR : L'arme demandee n'existe pas.\n";
        }
        System.out.println(res);
    }

    /**
     * Cherche dans la liste des terriens le terrien dont l'id est passe en parametre.
     * @param id
     * @return le terrien dont l'id est passe en parametre
     */
    public static Terrien getTerrien(Integer id){
        Terrien t = null;
        for (Terrien tcheck : listeTerriens) {
            if (tcheck.getId() == id && tcheck.getVie() > 0) {
                t = tcheck;
            }
        }
        return t;
    }

    /**
     * Cherche dans la liste des arcturiens l'arcturien dont l'id est passe en parametre.
     * @param id
     * @return l'arcturien dont l'id est passe en parametre
     */
    public static Arcturien getArcturien(Integer id){
        Arcturien a = null;
        for (Arcturien acheck : listeArcturiens) {
            if (acheck.getId() == id && acheck.getVie() > 0) {
                a = acheck;
            }
        }
        return a;
    }
    
    /**
     * Cherche dans la liste des armes l'arme dont l'id est passe en parametre.
     * @param id
     * @return l'arme dont l'id est passe en parametre
     */
    public static Arme getArme(Integer id){
        Arme a = null;
        for (Arme acheck : listeArmes) {
            if (acheck.getId() == id) {
                a = acheck;
            }
        }
        return a;
    }

    /**
     * Cherche dans la liste des terriens le terrien dont l'id est passe en parametre,
     * et cherche dans la liste des arcturiens l'arcturien dont l'id est passe en parametre.
     * Inflige des degats a l'arcturien passe en parametre egaux a la force du terrien passe en parametre.
     * Affiche des messages de succes ou d'erreur.
     * @param idTerrien
     * @param idArcturien
     */
    public static void terrienFrappeArcturien(Integer idTerrien, Integer idArcturien){
        String res = "";

        if (getTerrien(idTerrien) != null && getArcturien(idArcturien) != null) {
            //les deux existent, on attaque
            Integer dmg = getTerrien(idTerrien).getDamageOutput();
            getArcturien(idArcturien).recevoirCoup(dmg);
            res = "Le terrien "+idTerrien+" attaque "+idArcturien+" pour "+dmg+" dmg.\n";
        }
        else if (getTerrien(idTerrien) == null){
            res += "ERR : Le terrien demande n'existe pas.\n";
        }
        else if (getArcturien(idArcturien) == null){
            res += "ERR : L'arcturien demande n'existe pas.\n";
        }

        System.out.println(res);
    }

    /**
     * Cherche dans la liste des arcturiens l'arcturien dont l'id est passe en parametre,
     * et cherche dans la liste des terriens le terrien dont l'id est passe en parametre.
     * Inflige des degats au terrien passe en parametre egaux a la force de l'arcturien passe en parametre.
     * Affiche des messages de succes ou d'erreur.
     * @param idArcturien
     * @param idTerrien
     */
    public static void arcturienFrappeTerrien(Integer idArcturien, Integer idTerrien){
        String res = "";

        if (getTerrien(idTerrien) != null && getArcturien(idArcturien) != null) {
            //les deux existent, on attaque
            Integer dmg = Arcturien.getForce();
            getTerrien(idTerrien).recevoirCoup(dmg);
            res = "L'arcturien "+idArcturien+" attaque "+idTerrien+" pour "+dmg+" dmg.\n";
        }
        else if (getTerrien(idTerrien) == null){
            res += "ERR : Le terrien demande n'existe pas.\n";
        }
        else if (getArcturien(idArcturien) == null){
            res += "ERR : L'arcturien demande n'existe pas.\n";
        }

        System.out.println(res);
    }

    /**
     * Donne des informations sur le terrien dont l'id est passe en parametre.
     * @param idTerrien
     * @return informations sur le terrien dont l'id est passe en parametre.
     */
    public static String infoTerrien(Integer idTerrien) {
        String res;
        if (getTerrien(idTerrien).getVie() <= 0){
            res = "Le terrien "+idTerrien+" est mort ! Ne reveillez pas un fantome...";
        } else {
            res = getTerrien(idTerrien).toString();
        }
        return res;
    }

    /**
     * Donne des informations sur l'arme dont l'id est passe en parametre.
     * @param idArme
     * @return informations sur l'arme dont l'id est passe en parametre.
     */
    public static String infoArme(Integer idArme) {
        return getArme(idArme).toString();
    }

    /**
     * Donne des informations sur l'arcturien dont l'id est passe en parametre.
     * @param idArcturien
     * @return informations sur l'arcturien dont l'id est passe en parametre.
     */
    public static String infoArcturien(Integer idArcturien) {
        String res;
        if (getArcturien(idArcturien).getVie() <= 0){
            res = "L'arcturien "+idArcturien+" est mort ! Ne reveillez pas un fantome...";
        } else {
            res = getArcturien(idArcturien).toString();
        }
        return res;
    }

    /**
     * Renvoie la liste des terriens sous forme de texte.
     * @return liste des terriens.
     */
    public static String enumTerriens(){
        String res = "{ ";
        for (Terrien t : Jeu.listeTerriens) {
            if (t.getVie() > 0) {
                res += t.getId();
                res += " ";
            }
        }
        res += "}";
        return res;
    }

    /**
     * Renvoie la liste des armes sous forme de texte.
     * @return liste des armes.
     */
    public static String enumArmes(){
        String res = "{ ";
        for (Arme a : Jeu.listeArmes) {
            res += a.getId();
            res += " ";
        }
        res += "}";
        return res;
    }

    /**
     * Renvoie la liste des arcturiens sous forme de texte.
     * @return liste des arcturiens.
     */
    public static String enumArcturiens(){
        String res = "{ ";
        for (Arcturien a : Jeu.listeArcturiens) {
            if (a.getVie() > 0) {
                res += a.getId();
                res += " ";
            }
        }
        res += "}";
        return res;
    }
}