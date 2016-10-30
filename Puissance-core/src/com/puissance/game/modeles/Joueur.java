/**
 * 
 */
package com.puissance.game.modeles;

import com.badlogic.gdx.graphics.Color;

/**
 * @author Maxime Genevier
 *
 */
public class Joueur {
	
	private Color couleur;
	private boolean doitJouer = false;
	
	public Joueur(){
		super();
	}
	
	public Joueur(Color couleur, boolean doitJouer){
		super();
		this.couleur = couleur;
		this.doitJouer = doitJouer;
	}

	/**
	 * @return the couleur
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the doitJouer
	 */
	public boolean isDoitJouer() {
		return doitJouer;
	}

	/**
	 * @param doitJouer the doitJouer to set
	 */
	public void setDoitJouer(boolean doitJouer) {
		this.doitJouer = doitJouer;
	}
}
