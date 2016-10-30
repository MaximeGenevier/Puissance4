/**
 * 
 */
package com.puissance.game.vues;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.puissance.game.modeles.Case;
import com.puissance.game.modeles.Jeu;

/**
 * @author Maxime Genevier
 *
 */
public class VueJeu {
	
	private static final float CAMERA_WIDTH = 7f;
	private static final float CAMERA_HEIGHT = 6f;
	
	private Jeu jeu;
	private OrthographicCamera camera;
	
	private ShapeRenderer renduDebug = new ShapeRenderer();
	
	private SpriteBatch spriteBatch;
	private boolean debug = false;
	
	private int width;
	private int height;
	private float ppuX;
	private float ppuY;
	
	public VueJeu(Jeu jeu, boolean debug){
		this.jeu = jeu;
		this.camera = new OrthographicCamera(VueJeu.CAMERA_WIDTH, VueJeu.CAMERA_HEIGHT);
		this.camera.position.set(VueJeu.CAMERA_WIDTH/2f, VueJeu.CAMERA_HEIGHT/2f,0);
		this.camera.update();
		this.debug = debug;
		this.spriteBatch = new SpriteBatch();
	}
	
	
	public void render(){
		if(debug){
			this.dessinerDebug();
		}
	}

	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
		this.ppuX = (float)width / VueJeu.CAMERA_WIDTH;
		this.ppuY = (float) height / VueJeu.CAMERA_HEIGHT;
	}

	private void dessinerDebug() {
		
		this.renduDebug.setProjectionMatrix(camera.combined);
		this.renduDebug.begin(ShapeType.Line);
		
		for(int i =0; i < this.jeu.getPlateau().getWidth(); i++){
			for(int j=0; j < this.jeu.getPlateau().getHeight(); j++){
				Rectangle rectangle = this.jeu.getPlateau().getTabCases()[i][j].getLimites();
				this.renduDebug.setColor(new Color(0,0,1,1));
				this.renduDebug.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
			}
		}
		
		for(int i=0; i <  this.jeu.getPlateau().getWidth(); i++){
			for(int j=0; j< this.jeu.getPlateau().getHeight(); j++){
				if(this.jeu.getPlateau().getTabCases()[i][j].getSonJeton() != null){
					Circle cercle = this.jeu.getPlateau().getTabCases()[i][j].getSonJeton().getLimites();
					this.renduDebug.setColor(this.jeu.getPlateau().getTabCases()[i][j].getSonJeton().getLeJoueur().getCouleur());
					this.renduDebug.circle(cercle.x + 0.5f , cercle.y + 0.5f, cercle.radius, 50);					
				}
				
	
			}
		}

		this.renduDebug.end();
		
	}

}
