/**
 * 
 */
package com.puissance.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.puissance.game.controleurs.ControleurJeu;
import com.puissance.game.modeles.Jeu;
import com.puissance.game.vues.VueJeu;

/**
 * @author maxime
 *
 */
public class EcranJeu implements Screen, InputProcessor{

	private Jeu jeu;
	private VueJeu vueJeu;
	
	private int width, height;
	private Music music;
	private ControleurJeu controleur;

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.jeu = new Jeu();
		this.vueJeu = new VueJeu(jeu, true);
		this.controleur = new ControleurJeu(jeu);
		//this.music = Gdx.audio.newMusic(Gdx.files.internal("G:/Puissance/core/assets/Music/Bleach - Fade to black b13a.mp3"));
		//this.music.setLooping(true);
		//this.music.play();
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.vueJeu.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		this.width = width;
		this.height = height;
		this.vueJeu.setSize(width, height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		if(button == Input.Buttons.LEFT){
			this.controleur.jouerSonTour(screenX);
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
