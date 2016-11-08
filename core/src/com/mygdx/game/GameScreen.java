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
	private Hero hero;
	int x = 160;
	int y = 440;
	int i = 0;
	boolean inputKeyR;
	boolean inputKeyL;
	boolean inputKeyU;
	boolean inputKeyD;
	
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        this.batch = myGame.batch;
        this.firstMap = new FirstMap();
        this.hero = new Hero(x,y);
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
        
        if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
            System.out.println("KEY PRESSED");
            x += 40;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
            System.out.println("KEY PRESSED");
            x -= 40;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.UP)) {
            System.out.println("KEY PRESSED");
            y += 40;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
            System.out.println("KEY PRESSED");
            y -= 40;
        }
        //System.out.println(x);
    }
}
