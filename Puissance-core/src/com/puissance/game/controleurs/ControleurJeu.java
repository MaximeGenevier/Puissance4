/**
 * 
 */
package com.puissance.game.controleurs;

import javax.swing.JOptionPane;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.puissance.game.modeles.Jeton;
import com.puissance.game.modeles.Jeu;
import com.puissance.game.modeles.Joueur;

/**
 * @author maxime
 *
 */
public class ControleurJeu {
	
	private Jeu jeu;
	private Joueur joueurJaune;
	private Joueur joueurRouge;
	private int casesLibres = 42;
	private int coupSuccessifJaune = 0;
	private int coupSuccessifRouge = 0;
	
	public ControleurJeu(Jeu jeu){
		
		this.jeu = jeu;
		this.joueurJaune = this.jeu.getJoueurJaune();
		this.joueurRouge = this.jeu.getJoueurRouge();
		this.jeu.setJoueur(joueurJaune);
		
	}
	
	public void jouerSonTour(int screenX){
		
		//On affecte a i la valeur de screenX divisée par 100
		int i = screenX/92;
		Joueur dernierJoueur = null;
		
		//Tant qu'il n'y a pas de coup gagnant ou que la grille n'est pas pleine 
		//while(){
			//Si le joueur qui doit jouer est le joueur jaune
			if(this.jeu.getJoueur() == joueurJaune){
				
				//On pose le jeton du joueur jaune dans la colonne i et le joueur rouge doit jouer
				if(this.poserJeton(i, joueurJaune)){
					this.jeu.setJoueur(joueurRouge);
					dernierJoueur = joueurJaune;
					casesLibres--;
				}
				
			}
			
			//Sinon si c'est le joueur rogue
			else if(this.jeu.getJoueur() == joueurRouge){
					
				//On pose le jeton du joueur rouge dans la colonne i et le joueur jaune doit jouer
				if(this.poserJeton(i, joueurRouge)){
					this.jeu.setJoueur(joueurJaune);
					dernierJoueur = joueurRouge;
					casesLibres--;

				}
	
			}
			System.out.println(this.trouverQuatreJetons());
			if(this.trouverQuatreJetons()){
				JOptionPane.showMessageDialog(null, "Le joueur" + dernierJoueur.toString() , "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println(casesLibres);
		//}
		
	}
	
	public boolean trouverQuatreJetons(){
		
		for(int ligne = 0; ligne < this.jeu.getPlateau().getHeight(); ligne++){
			if(chercherAlign(0, ligne, 1, 0)){
				return true;
			}
		}
		
		for(int ligne = 0; ligne < this.jeu.getPlateau().getWidth(); ligne++){
			if(chercherAlign(ligne, 0, 0, 1)){
				return true;
			}
		}
		
		for(int ligne = 0; ligne < this.jeu.getPlateau().getWidth(); ligne++){
			if(chercherAlign(ligne, 0, 1, 1)){
				return true;
			}
			
			if(chercherAlign(ligne, 0, -1, 1)){
				return true;
			}
		}
		
		for(int colonne = 0; colonne < this.jeu.getPlateau().getHeight(); colonne++){
			if(chercherAlign(0, colonne, 1, 1)){
				return true;
			}
			
			if(chercherAlign(this.jeu.getPlateau().getHeight(), colonne, -1, 1)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean chercherAlign(int colonne, int ligne, int colonneRecherche, int ligneRecherche){
		int compteur = 0;
		
		Color couleur = null;
		
		int colonneActu = colonne;
		int ligneActu = ligne;
		
		while((colonneActu >= 0) && (colonneActu < this.jeu.getPlateau().getWidth()) && (ligneActu >0) && (ligneActu < this.jeu.getPlateau().getHeight())){
			if(this.jeu.getPlateau().getTabCases()[colonneActu][ligneActu].getSonJeton() != null){
				
				if(this.jeu.getPlateau().getTabCases()[colonneActu][ligneActu].getSonJeton().getLeJoueur().getCouleur() != couleur){
					couleur = this.jeu.getPlateau().getTabCases()[colonneActu][ligneActu].getSonJeton().getLeJoueur().getCouleur();
					compteur = 1;
					
				}
				else{
					compteur++;
					System.out.println(compteur);
				}
				
				//System.out.println(couleur);
			}
			
			if((couleur != null) && (compteur == 4)){
				return true;
			}
			
			colonneActu += colonneRecherche;
			ligneActu += ligneRecherche;
		}
		
		//Aucun alignement
		return false;
	}

	/**
	 * Méthode qui permet de positionner un jeton
	 * @param i
	 * @param x
	 * @param joueur
	 */
	public boolean poserJeton(int i,Joueur joueur){
		
		int x = 0; 
		
		//Si la dernière case est vide on lui affecte son jeton
		if(this.jeu.getPlateau().getTabCases()[i][0].getSonJeton() == null){
			
			this.jeu.getPlateau().getTabCases()[i][0].setSonJeton(new Jeton(new Vector2(i,x),joueur));
			return true;
				
		}
		
		//Sinon si elle a un jeton
		else if(this.jeu.getPlateau().getTabCases()[i][x].getSonJeton() != null){
				
			//Tant que les cases supérieures ont un jeton, on augmente x de 1
			while(this.jeu.getPlateau().getTabCases()[i][x].getSonJeton() != null && x < 5){
				x++;				
			}
			
			//Si la case est vide
			if(this.jeu.getPlateau().getTabCases()[i][x].getSonJeton() == null){
				//On lui affecte un jeton
				this.jeu.getPlateau().getTabCases()[i][x].setSonJeton(new Jeton(new Vector2(i,x),joueur));
				return true;
			}
			
			return false;
		}
		
		return false;
		
		
	}

}
