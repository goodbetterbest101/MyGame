package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HintBomb {
	private FirstMap firstMap;
	private SpriteBatch batch;
	private Texture bombImage;
	
	public HintBomb(SpriteBatch batch, FirstMap firstMap){
		this.firstMap = firstMap;
		this.batch = batch;
		bombImage = new Texture("bomb.png");
	}
}
