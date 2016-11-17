package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SecScreen {
	private SpriteBatch batch;
	private Texture backgroundImage;
	boolean thisScreen = true;
	
	
	public SecScreen(SpriteBatch batch){
		this.batch = batch;
		backgroundImage = new Texture("caution.jpg");
	}
	
	 public void render() {
	    	batch.begin();
	    	batch.draw(backgroundImage, 0, 0);
	    	if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
	    		thisScreen = false;
	    	}
	        batch.end();
	 }
}
