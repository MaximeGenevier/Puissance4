/**
 * 
 */
package com.puissance.game.modeles;

import java.util.List;

import com.badlogic.gdx.graphics.Color;

/**
 * @author maxime
 *
 */
public class Jeu {
	
	private Plateau plateau;
	private Joueur joueurJaune = new Joueur(new Color(1,1,0,1), true);
	private Joueur joueurRouge = new Joueur(new Color(1,0,0,1), false);
	private Joueur joueur;
	
	
	public Jeu(){
		this.creerJeu();
	}

	private void creerJeu() {
		
		this.plateau = new Plateau();
		
	}

	/**
	 * @return the plateau
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
	 * @param plateau the plateau to set
	 */
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	/**
	 * @return the joueurJaune
	 */
	public Joueur getJoueurJaune() {
		return joueurJaune;
	}

	/**
	 * @param joueurJaune the joueurJaune to set
	 */
	public void setJoueurJaune(Joueur joueurJaune) {
		this.joueurJaune = joueurJaune;
	}

	/**
	 * @return the joueurRouge
	 */
	public Joueur getJoueurRouge() {
		return joueurRouge;
	}

	/**
	 * @param joueurRouge the joueurRouge to set
	 */
	public void setJoueurRouge(Joueur joueurRouge) {
		this.joueurRouge = joueurRouge;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
}
