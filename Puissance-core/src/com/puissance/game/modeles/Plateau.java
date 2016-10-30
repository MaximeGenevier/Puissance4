/**
 * 
 */
package com.puissance.game.modeles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Maxime Genevier
 *
 */
public class Plateau {
	
	private Case[][] tabCases;
	
	private int width = 7;
	private int height = 6;
	
	public Plateau(){
		this.creerPlateau();
	}

	private void creerPlateau() {
		
		tabCases = new Case[width][height];
		for(int colonne = 0; colonne < width; colonne++){
			for(int ligne = 0; ligne < height; ligne++){
				tabCases[colonne][ligne] = new Case(new Vector2(colonne,ligne));
				//tabCases[colonne][ligne].setSonJeton(new Jeton(new Vector2(colonne,ligne)));
			}
		}	
		
	}

	/**
	 * @return the tabCases
	 */
	public Case[][] getTabCases() {
		return tabCases;
	}

	/**
	 * @param tabCases the tabCases to set
	 */
	public void setTabCases(Case[][] tabCases) {
		this.tabCases = tabCases;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
	
	

}
