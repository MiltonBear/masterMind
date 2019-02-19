/**
 * 
 */
package ca.csf.dfc.classe;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author administrateur
 *
 */
public abstract class Combinaison {

	final protected static String[] listeDeCouleur = { "bleu  ", "rouge ", "jaune ", "vert  ", "violet", "orange" };

	static int MINIMUM_NB_COULEURS = 2;
	static int MAXIMUM_NB_COULEURS = 6;
	static int MINIMUM_LONGUEUR_PUZZLE = 3;
	static int MAXIMUM_LONGUEUR_PUZZLE = 8;
	private int m_LongueurDuPuzzle;
	private int m_NbDeCouleur;
	ArrayList<String> m_combinaisonDeCouleur;


	public int getLongueurDuPuzzle() {
		return this.m_LongueurDuPuzzle;
	}

	public void setLongeurDuPuzzle(int p_LongueurDuPuzzle) {
		this.m_LongueurDuPuzzle = p_LongueurDuPuzzle;
	}

	public int getNbDeCouleur() {
		return this.m_NbDeCouleur;
	}

	public void setNbDeCouleur(int p_NbDeCouleur) {
		this.m_NbDeCouleur = p_NbDeCouleur;
	}

	public Combinaison(int p_LongueurDuPuzzle, int p_NbDeCouleur) {
		setLongeurDuPuzzle(p_LongueurDuPuzzle);
		setNbDeCouleur(p_NbDeCouleur);
		this.m_combinaisonDeCouleur = new ArrayList<String>();
	}

	/*
	 * change les string des bonnes couleurs au bonne place
	 * les bonne couleurs vont devenir "noir" dans la combinaison ordinateur, 
	 * noire dans la combinaison de lutilisateur
	 */
		public void PremiereEtapeChangerStringDesBonnesCouleursAuxBonnesPlaces(
			ArrayList<String> p_CombinaisonOrdinateur, ArrayList<String> p_CombinaisonUtilisateur) {
		for (int i = 0; i < p_CombinaisonOrdinateur.size(); i++) {
			if (p_CombinaisonOrdinateur.get(i)
					.equals(p_CombinaisonUtilisateur.get(i))) {
				p_CombinaisonOrdinateur.remove(i);
				p_CombinaisonOrdinateur.add(i, "noir");
				p_CombinaisonUtilisateur.remove(i);
				p_CombinaisonUtilisateur.add(i, "noire");
			}
		}
		
	}
/*
 * compte les string "noir" dans la combinaison de lordinateur
 */
		
	public String DeuxiemeEtapeCompterLesNoirs(ArrayList<String> p_listeAvecNoirsAjoute) {
		int compteur = 0;
		for (int i = 0; i < p_listeAvecNoirsAjoute.size(); i++) {
			if (p_listeAvecNoirsAjoute.get(i).equals("noir")) {
				compteur++;
			}	
		}
		String leNombreDeNoir=Integer.toString(compteur);
		return leNombreDeNoir;
	}

	/*
	 * compte les bonnes couleurs au mauvaises places
	 */
	public String DerniereVerificationCompterLesBlancs(ArrayList<String> p_ListeUtilisateur,ArrayList<String> p_listeOrdinateur) {
		int blanc = 0;
		for (int i = 0; i < p_ListeUtilisateur.size(); i++) {
			for (int j = 0; j < p_listeOrdinateur.size(); j++) {
				if (p_ListeUtilisateur.get(i).equals(p_listeOrdinateur.get(j))) {
					p_ListeUtilisateur.remove(i);
					p_ListeUtilisateur.add(i, "white");
					p_listeOrdinateur.remove(j);
					p_listeOrdinateur.add(j, "blanc");
					blanc++;
				}
			}
		}
		String leNombreDeBlanc=Integer.toString(blanc);
		return leNombreDeBlanc;
	}

	public ArrayList<String> validerLaSolution(CombinaisonOrdinateur p_Solution, CombinaisonUtilisateur p_Essaie) {

		
		ArrayList<String>copyOrdi=new ArrayList<String>(p_Solution.m_combinaisonDeCouleur);
		ArrayList<String>copyUser=new ArrayList<String>(p_Essaie.m_combinaisonDeCouleur);
		PremiereEtapeChangerStringDesBonnesCouleursAuxBonnesPlaces(copyOrdi,copyUser);
		/*System.out.println("solution");
		System.out.println(p_Solution.m_combinaisonDeCouleur);
		System.out.println(" ");
		System.out.println("guess");
		System.out.println(p_Essaie.m_combinaisonDeCouleur);
		System.out.println(" ");*/
		ArrayList<String>copyUser2=new ArrayList<String>(p_Essaie.m_combinaisonDeCouleur);
		copyUser2.add(DeuxiemeEtapeCompterLesNoirs(copyOrdi));
		copyUser2.add(DerniereVerificationCompterLesBlancs(copyOrdi, copyUser));
		
		return copyUser2;
		
	}

}
