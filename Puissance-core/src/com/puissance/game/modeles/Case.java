/**
 * 
 */
package com.puissance.game.modeles;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Maxime Genevier
 *
 */
public class Case {
	
	private static final float TAILLE = 1f;
	
	private Vector2 position = new Vector2();
	private Rectangle limites = new Rectangle();
	private Jeton sonJeton;
	
	public Case(Vector2 position){
		this.position = position;
		this.limites.height = Case.TAILLE;
		this.limites.width = Case.TAILLE;
		this.limites.x = this.position.x;
		this.limites.y = this.position.y;
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
	public Rectangle getLimites() {
		return limites;
	}

	/**
	 * @param limites the limites to set
	 */
	public void setLimites(Rectangle limites) {
		this.limites = limites;
	}

	/**
	 * @return the taille
	 */
	public static float getTaille() {
		return TAILLE;
	}

	/**
	 * @return the sonJeton
	 */
	public Jeton getSonJeton() {
		return sonJeton;
	}

	/**
	 * @param sonJeton the sonJeton to set
	 */
	public void setSonJeton(Jeton sonJeton) {
		this.sonJeton = sonJeton;
	}
	
	

}
