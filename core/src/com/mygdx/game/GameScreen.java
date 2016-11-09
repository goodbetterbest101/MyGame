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
	int state_r = 0;
	int state_c = 0;
	int state_x = 200;
	int state_y = 440;
	boolean moveArea = true;
	
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
        
    	state_c = x/40;
    	state_r = (560-y)/40;
    	Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		firstMapRenderer.render();
        batch.begin();
        batch.draw(HeroImg, x, y);
        batch.end();
       
       firstMap.stateC = state_x/40;
       firstMap.stateR = (560-state_y)/40;
       System.out.println(firstMap.stateC + "   " + firstMap.stateR);
        
        if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && x < state_x + 40) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x+40)/40, (560-y)/40) && firstMap.canMoveDirection((560-y)/40, (x+40)/40))
            	x += 40;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x-40)/40, (560-y)/40) && firstMap.canMoveDirection((560-y)/40, (x-40)/40))
            	x -= 40;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x)/40, (520-y)/40) && firstMap.canMoveDirection((520-y)/40, (x)/40))
            	y += 40;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x)/40, (600-y)/40) && firstMap.canMoveDirection((600-y)/40, (x)/40))
            	y -= 40;
        }
        else if (Gdx.input.isKeyJustPressed(Keys.SPACE)){
        	firstMap.changeOldState();
        	state_x = x;
        	state_y = y;
        }
        //System.out.println(x);
    }
}
