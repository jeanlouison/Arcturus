package view;

import control.Jeu;

import java.util.Scanner;

class View {

    private static Scanner sc;

	/**
	 * fonction principale du jeu, qui initialise le jeu et
	 * qui boucle pour afficher les choix a l'utilisateur et ecouter ses reponses.
	 */
    public static void launchGame() {

        sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        Jeu.init(20, 200);
		
		while(true) {
			int choix = View.menuPrincipal();
			
			switch(choix) {
			case -1:
				break;
			case 1:
				creerTerrien();
				break;
			case 2:
                creerArcturien();
				break;
			case 3:
                creerArme();
				break;
			case 4:
                donnerArme();
				break;
			case 5:
                arcturienFrappeTerrien();
				break;
			case 6:
                terrienFrappeArcturien();
                break;
			case 7:
				information();
				break;
			case 0:
				arreter();
				break;
			default:
				System.out.println("Choix impossible");
			}
		}		
    }

	/**
	 * fonction de lecture de reponse controlee
	 * @param int[] tableau d'entier a remplir par l'utilisateur
	 * @throw RuntimeException si l'utilsateur frappe une reponse non entiere ou
	 * ne fournit pas assez d'arguments.
	 * 
	 * super fonction realisee par le prof.
	 */
	private static void lireLigne(int[] param) {
		String[] ligne = sc.next().split("\\s");	
		try {
			for (int i=0, l = param.length; i < l; i++)
				param[i]= Integer.parseInt(ligne[i]);
		}		
		catch (NumberFormatException e) {
			throw new RuntimeException("Argument invalide");
		}
		catch (IndexOutOfBoundsException e) {
			throw new RuntimeException("Argument manquant");	
		}
	}
	
	/**
	 * Affiche le menu
	 * @return le choix de l'utilisateur (-1 si la frappe 
	 * de l'utilisateur n'est pas correcte)
	 * 
	 * super fonction realisee par le prof.
	 */
	private static int menuPrincipal() {
		System.out.print(  
				" - - - - - - - - - - - - - -\n" +
				"| 1 | Creer terrien         |\n" + 
				"| 2 | Creer arcturien       |\n" + 
				"| 3 | Creer arme            |\n" + 
				"| 4 | Donner arme           |\n" + 
				"| 5 | Arcturien vs. Terrien |\n" +
                "| 6 | Terrien vs. Arcturien |\n" +
				"| 7 | Information           |\n" +
				"| 0 | Finir                 |\n" +
				" - - - - - - - - - - - - - -\n? " 
				);
		int[] choix = new int[] {-1};
		try {
			lireLigne(choix);
		}
		catch (Exception e) {
			System.out.println("Saisir un entier ...");
		}
		return choix[0];
	}

	/**
	 * confirmation de l'arret du programme,
	 * demandant une deuxieme reponse de la part de l'utilisateur.
	 * 
	 * super fonction realisee par le prof.
	 */
    private static void arreter() {
		System.out.println("Taper 0 pour confirmer l'arret.");
		int[] param = new int[1];
		try {
			lireLigne(param);
		}
		catch (Exception e) {
			System.out.println( e.getMessage());
			return;
		}
		if (param[0] == 0) {
			sc.close();
			System.out.println("Au revoir.");
			System.exit(0);
		}
	}

	/**
	 * 
	 */
	private static void information() {
		//choix de l'information souhaitee
		System.out.print(	" - - - - - - - - - - - - - - -\n" +
							"| 1 | Informations terrien   |\n" + 
							"| 2 | Informations arcturien |\n" + 
							"| 3 | Informations arme      |\n" +
							" - - - - - - - - - - - - - - -\n");
        int[] choix = {-1};
        try {
			lireLigne(choix);
        }
        catch (Exception e) {
			System.out.println("Saisir un entier ...");
			return;
		}
        switch(choix[0]) {
			case -1 :
				break;
			case 1 :
				System.out.println("Sur quel terrien voulez vous en savoir + ? liste des terriens vivants :");
				System.out.println(Jeu.enumTerriens());
				int[] choixTerrien = {-1};
				try {
					lireLigne(choixTerrien);
				}
				catch (Exception e) {
					System.out.println("Saisir un entier ...");
					break;
				}
				System.out.println(Jeu.infoTerrien(choixTerrien[0]));

			case 2 :
				System.out.println("Sur quel arcturien voulez vous en savoir + ? liste des arcturiens vivants :");
				System.out.println(Jeu.enumArcturiens());
				int[] choixArcturien = {-1};
				try {
					lireLigne(choixArcturien);
				}
				catch (Exception e) {
					System.out.println("Saisir un entier ...");
					break;
				}
				System.out.println(Jeu.infoArcturien(choixArcturien[0]));

			case 3 :
			System.out.println("Sur quel arme voulez vous en savoir + ? liste des armes :");
				System.out.println(Jeu.enumArmes());
				int[] choixArme = {-1};
				try {
					lireLigne(choixArme);
				}
				catch (Exception e) {
					System.out.println("Saisir un entier ...");
					break;
				}
				System.out.println(Jeu.infoArme(choixArme[0]));
			
			default:
			System.out.println("Choix impossible");
		}
	}

	/**
	 * Demande la puissance souhaitee de l'arme a l'utilisateur
	 * et cree l'arme souhaitee
	 */
    private static void creerArme() {
        System.out.println("Puissance ?");
        int[] param = {-1};
        try {
                lireLigne(param);
        }
        catch (Exception e) {
			System.out.println( e.getMessage() );
			return;
        }
        Jeu.creerArme(param[0]);
    }

	/**
	 * Demande quel arme donner a quel terrien et execute l'action,
	 * apres avoir affiche les listes respectives.
	 */
    private static void donnerArme() {
		System.out.println("Terrien ? Arme ?");
		System.out.println("Liste des terriens : "+Jeu.enumTerriens());
		System.out.println("Liste des armes : "+Jeu.enumArmes());
        int[] param = new int[2];
        try {
                lireLigne(param);
        }
        catch (Exception e) {
                System.out.println( e.getMessage() );
                return;
        }
        Jeu.donnerArme(param[0], param[1]);
    }

	/**
	 * Demande quel terrien frapper avec quel arcturien,
	 * apres avoir affiche les listes respectives.
	 */
    private static void arcturienFrappeTerrien() {
		System.out.println("Arcturien ? Terrien ?");
		System.out.println("Liste des arcturiens : "+Jeu.enumArcturiens());
		System.out.println("Liste des terriens : "+Jeu.enumTerriens());
        int[] param = new int[2];
        try {
                lireLigne(param);
        }
        catch (Exception e) {
                System.out.println( e.getMessage() );
                return;
        }
        Jeu.arcturienFrappeTerrien(param[0], param[1]);
    }

	/**
	 * Demande quel arcturien frapper avec quel terrien,
	 * apres avoir affiche les listes respectives.
	 */
    private static void terrienFrappeArcturien() {
		System.out.println("Terrien ? Arcturien ?");
		System.out.println("Liste des terriens : "+Jeu.enumTerriens());
		System.out.println("Liste des arcturiens : "+Jeu.enumArcturiens());
        int[] param = new int[2];
        try {
                lireLigne(param);
        }
        catch (Exception e) {
                System.out.println( e.getMessage() );
                return;
        }
        Jeu.terrienFrappeArcturien(param[0], param[1]);
    }

	/**
	 * Cree un terrien, attribution d'id automatique
	 */
    private static void creerTerrien() {
        Jeu.creerTerrien();
    }

	/**
	 * Cree un arcturien, attribution d'id automatique
	 */
    private static void creerArcturien() {
        Jeu.creerArcturien();
    }
}
