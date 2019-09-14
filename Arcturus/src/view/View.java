package view;
import arcturus.control.Jeu;
import java.util.Scanner;

class View {

    private static Scanner sc;

    public static void launchGame() {

        sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        Jeu.init();
		
		while(true) {
			int choix = View.menuPrincipal();
			
			switch(choix) {
			case -1:
				break;
			case 1:
				Jeu.creerTerrien();
				break;
			case 2:
                Jeu.creerArcturien();
				break;
			case 3:
                Jeu.creerArme();
				break;
			case 4:
                Jeu.donnerArme();
				break;
			case 5:
                Jeu.frapper();
				break;
			// case 6:
			// 	information();
			// 	break;
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
	
	/* (non javadoc)
	 * Affiche le menu
	 * @return le choix de l'utilisateur (-1 si la frappe 
	 * de l'utilisateur n'est pas correcte)
	 */
	private static int menuPrincipal() {
		System.out.print(  
				" - - - - - - - - - - - -\n" +
				"| 1 | Creer terrien     |\n" + 
				"| 2 | Creer arcturien   |\n" + 
				"| 3 | Creer arme        |\n" + 
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

    private static void arreter() {
		System.out.println("Taper 0 pour confirmer l'arrÃªt");
		int[] param = new int[1];
		try {
			Jeu.lireLigne(param);
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