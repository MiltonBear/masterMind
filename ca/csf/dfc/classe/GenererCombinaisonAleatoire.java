/**
 * 
 */
package ca.csf.dfc.classe;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author administrateur
 *
 */
public class GenererCombinaisonAleatoire implements GenerationCombinaisonStrategy {

	private String genererUneCouleurOrdinateur(Combinaison p_Combinaison)
	{
		//p_Combinaison.m_combinaisonDeCouleur.clear();
		
		Random couleurAleatoire=new Random();
	    String couleur=Combinaison.listeDeCouleur[couleurAleatoire.nextInt((p_Combinaison.getNbDeCouleur()))];
		
		return couleur;
	}
	@Override
	public void genererCombinaison(Combinaison p_Combinaison) {
		p_Combinaison.m_combinaisonDeCouleur.clear();
		
		
		ArrayList<String> combOrdi=new ArrayList<String>(p_Combinaison.m_combinaisonDeCouleur);

		for (int i = 0; i < p_Combinaison.getLongueurDuPuzzle(); i++) {
			
			p_Combinaison.m_combinaisonDeCouleur.add(i, genererUneCouleurOrdinateur(p_Combinaison));
			
		}
	
	}

}
