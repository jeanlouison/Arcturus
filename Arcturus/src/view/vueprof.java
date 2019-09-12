package arcturus.view;

import java.util.Scanner;

import arcturus.control.controller;

/**
 * Interface utilisateur.
 * Sollicite et transmet au contrÃ´leur les entrÃ©es de l'utilsateur 
 * qui doivent Ãªtre de type entiers sÃ©parÃ©s par des espaces
 */
public class Console {

	private ControleurJeu cj;
	private Scanner sc;
	
	/**
	 * Instancie la vue sur la console.
	 * @param cj: contrÃ´leur
	 */
	public Console(ControleurJeu cj) {
		this.cj = cj;
		
		sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		while(true) {
			int choix = menuPrincipal();
			
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
				frapper();
				break;
			case 6:
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

	/* (non javadoc)
	 * Lecture controlÃ©e.
	 * @param: tableau d'entier Ã  remplir par l'utilisateur
	 * @throw RuntimeException si l'utilsateur frappe une rÃ©ponse 
	 * non entiÃ¨re ou ne fournit pas assez d'arguments
	 */
	private void lireLigne(int[] param) {
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
	
	/* (non javadoc)
	 * Affiche le menu
	 * @return le choix de l'utilisateur (-1 si la frappe 
	 * de l'utilisateur n'est pas correcte)
	 */
	private int menuPrincipal() {
		System.out.print(  
				" - - - - - - - - - - - -\n" +
				"| 1 | CrÃ©er terrien     |\n" + 
				"| 2 | CrÃ©er arcturien   |\n" + 
				"| 3 | CrÃ©er arme        |\n" + 
				"| 4 | Donner arme       |\n" + 
				"| 5 | Frapper           |\n" +
				"| 6 | Information       |\n" +
				"| 0 | Finir             |\n" +
				" - - - - - - - - - - - -\n? " 
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
	
	/* (non javadoc)
	 * Affiche l'identifiant et les caractÃ©ristiques du terrien crÃ©Ã©.
	 */
	private void creerTerrien() {
		System.out.println( cj.information( cj.creerTerrien() ) );
	}

	/* (non javadoc)
	 * Affiche l'identifiant et les caractÃ©ristiques de l'arcturien crÃ©Ã©.
	 * Affiche un message d'erreur lorsque la saisie ne peut Ãªtre convertie 
	 * en entier 
	 */
	private void creerArcturien() {
		System.out.print("Force ? ");
		int[] param = new int[1];
		try {
			lireLigne(param);
		}
		catch (Exception e) {
			System.out.println( e.getMessage() );
			return;
		}
		System.out.println( cj.information( cj.creerArcturien(param[0]) ) );	
	}	

	/* (non javadoc)
	 * Affiche l'identifiant et les caractÃ©ristiques de l'arme crÃ©Ã©e.
	 * Affiche un message d'erreur lorsque la saisie ne peut Ãªtre convertie 
	 * en entier 
	 */
	private void creerArme() {
		System.out.print("Puissance ? ");
		int[] param = {-1};
		try {
			lireLigne(param);
		}
		catch (Exception e) {
			System.out.println( e.getMessage() );
			return;
		}
		System.out.println( cj.information( cj.creerArme(param[0]) ) );
		
	}

	/* (non javadoc)
	 * Affiche l'identifiant et les caractÃ©ristiques du terrien aprÃ¨s reception de l'arme.
	 * Affiche un message d'erreur lorsque la saisie ne peut Ãªtre convertie 
	 * en entier ou lorsque le nombre d'arguments est insuffisant
	 */
	private void donnerArme() {
		System.out.print("Terrien ? Arme ? ");
		int[] param = new int[2];
		try {
			lireLigne(param);
		}
		catch (Exception e) {
			System.out.println( e.getMessage() );
			return;
		}
		cj.donnerArme(param[0], param[1]);
		System.out.println( cj.information( param[0] ) );
		
	}

	/* (non javadoc)
	 * Affiche l'identifiant et les caractÃ©ristiques de la victime qui a Ã©tÃ© frappÃ©e.
	 * Affiche un message d'erreur lorsque la saisie ne peut Ãªtre convertie 
	 * en entier ou lorsque le nombre d'arguments est insuffisant
	 */
	private void frapper() {
		System.out.print("Attaquant ? Victime ? ");
		int[] param = new int[2];
		try {
			lireLigne(param);
		}
		catch (Exception e) {
			System.out.println( e.getMessage());
			return;
		}
		cj.frapper(param[0], param[1]);
		System.out.println( cj.information( param[1] ) );
	}

	/* (non javadoc)
	 * Affiche la table des objets crÃ©Ã©s par l'utilisateur.
	 */
	private void information() {
		System.out.println( cj.information() );		
	}
	
	/* (non javadoc)
	 * Termine l'application aprÃ¨s confirmation par l'utilisateur
	 * (revient au menu principal si l'utilsateur ne confirme pas).
	 * Affiche un message d'erreur lorsque la saisie ne peut Ãªtre convertie 
	 * en entier.
	 */	
	private void arreter() {
		System.out.println("Taper 0 pour confirmer l'arrÃªt");
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
	
}
	

	
