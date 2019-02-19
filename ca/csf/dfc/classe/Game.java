/**
 * 
 */
package ca.csf.dfc.classe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author administrateur
 *
 */
public class Game {

	private int m_NbTours = 0;
	private int m_NbGames;
	ArrayList<ArrayList<String>> listeDessaieEtReponse = new ArrayList<ArrayList<String>>();

	public Game() {

		menu();
	}

	public void menu() {
		int nombreDeCouleur = -1;
		int longueurPuzzle = -1;

		while (nombreDeCouleur < Combinaison.MINIMUM_NB_COULEURS || nombreDeCouleur > Combinaison.MAXIMUM_NB_COULEURS) {
			System.out.println("avec combien de couleur voulez-vous jouer?");
			System.out.println("(minimum:" + Combinaison.MINIMUM_NB_COULEURS + ") (maximum:"
					+ Combinaison.MAXIMUM_NB_COULEURS + ")");
			System.out.println(": ");
			Scanner scanCouleur = new Scanner(System.in);
			String nbcolor = scanCouleur.nextLine();
			nombreDeCouleur = Integer.parseInt(nbcolor);
		}

		while (longueurPuzzle < Combinaison.MINIMUM_LONGUEUR_PUZZLE
				|| longueurPuzzle > Combinaison.MAXIMUM_LONGUEUR_PUZZLE) {
			System.out.println("déterminer la longueur du Puzzle");
			System.out.println("(minimum:" + Combinaison.MINIMUM_LONGUEUR_PUZZLE + ") maximum:"
					+ Combinaison.MAXIMUM_LONGUEUR_PUZZLE);
			Scanner scanLongueur = new Scanner(System.in);
			String longueur = scanLongueur.nextLine();
			longueurPuzzle = Integer.parseInt(longueur);
		}

		CombinaisonOrdinateur combO = new CombinaisonOrdinateur(longueurPuzzle, nombreDeCouleur);
		GenererCombinaisonAleatoire listOrdi = new GenererCombinaisonAleatoire();
		listOrdi.genererCombinaison(combO);
		CombinaisonUtilisateur combU = new CombinaisonUtilisateur(longueurPuzzle, nombreDeCouleur);
		GenererCombinaisonAleatoire listUtilisateur = new GenererCombinaisonAleatoire();
		int compteur = 0;

		while (!(combO.m_combinaisonDeCouleur.equals(combU.m_combinaisonDeCouleur))) {

			// utilisateur essaye une combinaison
			listUtilisateur.genererCombinaison(combU);
			listeDessaieEtReponse.add(combU.validerLaSolution(combO, combU));
			// affiche la liste dessaie deja jouer

			for (int i = 0; i < listeDessaieEtReponse.size(); i++) {
				System.out.println(listeDessaieEtReponse.get(i));
			}
			System.out.println("");
			compteur++;
		}
		System.out.println("Vous avez gagner en "+compteur + " tours");
		
	}

}
