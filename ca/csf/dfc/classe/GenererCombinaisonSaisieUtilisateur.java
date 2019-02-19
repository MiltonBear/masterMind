/**
 * 
 */
package ca.csf.dfc.classe;

import java.util.Scanner;

/**
 * @author administrateur
 *
 */
public class GenererCombinaisonSaisieUtilisateur implements GenerationCombinaisonStrategy {

	private String GenererCouleurInput(Combinaison p_Combinaison) {
		String couleur = "";
		int couleurSaisi = -1;
		while (couleurSaisi <= 0 || couleurSaisi > p_Combinaison.getNbDeCouleur()) {
			Scanner scannerCouleur = new Scanner(System.in);
			String couleurScan = scannerCouleur.nextLine();
			couleurSaisi = Integer.parseInt(couleurScan);
		}
			switch (couleurSaisi) {
			case 1:
				couleur = Combinaison.listeDeCouleur[0];
				System.out.println(Combinaison.listeDeCouleur[0]);
				break;
			case 2:
				couleur = Combinaison.listeDeCouleur[1];
				System.out.println(Combinaison.listeDeCouleur[1]);
				break;
			case 3:
				couleur = Combinaison.listeDeCouleur[2];
				System.out.println(Combinaison.listeDeCouleur[2]);
				break;
			case 4:
				couleur = Combinaison.listeDeCouleur[3];
				System.out.println(Combinaison.listeDeCouleur[3]);
				break;
			case 5:
				couleur = Combinaison.listeDeCouleur[4];
				System.out.println(Combinaison.listeDeCouleur[4]);
				break;
			case 6:
				couleur = Combinaison.listeDeCouleur[5];
				System.out.println(Combinaison.listeDeCouleur[5]);
				break;
		}
		return couleur;
	}

	@Override
	public void genererCombinaison(Combinaison p_Combinaison) {
		p_Combinaison.m_combinaisonDeCouleur.clear();
		for (int i = 0; i < p_Combinaison.getLongueurDuPuzzle(); i++) {
			int compteur = i + 1;
			System.out.println("couleur #"+compteur);
			p_Combinaison.m_combinaisonDeCouleur.add(i, GenererCouleurInput(p_Combinaison));
		}

	}

}
