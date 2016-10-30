/**
 * 
 */
package com.puissance.game.modeles;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Maxime Genevier
 *
 */
public class Jeton {
	
	private static final float TAILLE = 0.40f;
	
	private Joueur leJoueur;
	
	private Vector2 position = new Vector2();
	private Circle limites = new Circle();
	
	public Jeton(Vector2 position, Joueur leJoueur){
		this.position = position;
		this.limites.radius = Jeton.TAILLE;
		this.limites.x = this.position.x;
		this.limites.y = this.position.y;
		this.leJoueur = leJoueur;
	}

	/**
	 * @return the position
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	/**
	 * @return the limites
	 */
	public Circle getLimites() {
		return limites;
	}

	/**
	 * @param limites the limites to set
	 */
	public void setLimites(Circle limites) {
		this.limites = limites;
	}

	/**
	 * @return the taille
	 */
	public static float getTaille() {
		return TAILLE;
	}

	/**
	 * @return the leJoueur
	 */
	public Joueur getLeJoueur() {
		return leJoueur;
	}

	/**
	 * @param leJoueur the leJoueur to set
	 */
	public void setLeJoueur(Joueur leJoueur) {
		this.leJoueur = leJoueur;
	}
	
	

}
