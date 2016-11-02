package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private MyGame myGame;
	private Texture HeroImg;
	private SpriteBatch batch;
	private FirstMapRenderer firstMapRenderer;
	private FirstMap firstMap;
	int x = 40;
	int y = 520;
	int i = 0;
	int tempX = x;
	int tempY = y;
	boolean inputKeyR;
	boolean inputKeyL;
	boolean inputKeyU;
	boolean inputKeyD;
	
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        this.batch = myGame.batch;
        this.firstMap = new FirstMap();
        this.firstMapRenderer = new FirstMapRenderer(myGame.batch,firstMap);
        HeroImg = new Texture("pacman.png");
    }
    
    @Override
    public void render(float delta) {
        //System.out.println("Hello " + delta);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		firstMapRenderer.render();
        batch.begin();
        batch.draw(HeroImg, x, y);
        batch.end();
        inputKeyR = false;
        inputKeyL = false;
        inputKeyU = false;
        inputKeyD = false;
        
        if(Gdx.input.isKeyPressed(Keys.RIGHT) && x < tempX + 40) {
            inputKeyR = true;	
        	x += 20;
        }
        else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            inputKeyL = true;	
        }
        else if(Gdx.input.isKeyPressed(Keys.UP)) {
            inputKeyU = true;	
        }
        else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            inputKeyD = true;	
        }
        System.out.println(x);
    }
}
