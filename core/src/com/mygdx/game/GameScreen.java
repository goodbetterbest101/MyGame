package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private MyGame myGame;
	private Texture HeroImg;
	private SpriteBatch batch;
	private FirstMapRenderer firstMapRenderer;
	private FirstMap firstMap;
	private SecMapRenderer secMapRenderer;
	private SecMap secMap;
	private Hero hero;
	private BitmapFont font;
	private OrthographicCamera camera;
	private Texture gameOverImage;
	
	int x = 160;
	int y = 440;
	int state_r = 0;
	int state_c = 0;
	int state_x = 200;
	int state_y = 440; 
	boolean moveArea = true;
	boolean createBomb = false;
	boolean touch = false;
	boolean gameOver = false;
	int map = 0;
	
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        this.batch = myGame.batch;
        this.firstMap = new FirstMap();
        this.hero = new Hero(x,y);
        this.firstMapRenderer = new FirstMapRenderer(myGame.batch,firstMap);
        this.secMap = new SecMap();
        this.secMapRenderer = new SecMapRenderer(myGame.batch,secMap);
        font = new BitmapFont();
        camera = new OrthographicCamera();
        HeroImg = new Texture("hero.png");
        gameOverImage = new Texture("gameover.png");
    }
    
    public void resize(int width, int height) {
        //we will use lower-left as our origin (0, 0)
        camera.setToOrtho(false, width, height);
        //we need to update our batch with the new camera matrices
        batch.setProjectionMatrix(camera.combined);
    }

    public void updateFirst(){
    	
    	if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && x < state_x + 40) {  //state_x + 40 is limit state to pressed key
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x+40)/40, (560-y)/40) && firstMap.canMoveDirection((560-y)/40, (x+40)/40)) {
            	x += 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x-40)/40, (560-y)/40) && firstMap.canMoveDirection((560-y)/40, (x-40)/40)) {
            	x -= 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x)/40, (520-y)/40) && firstMap.canMoveDirection((520-y)/40, (x)/40)) {
            	y += 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x)/40, (600-y)/40) && firstMap.canMoveDirection((600-y)/40, (x)/40)) {
            	y -= 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.SPACE)){
       		firstMap.changeOldState();
        	state_x = x;
        	state_y = y;
        	touch = false;
        }
    }
    
    public void updateSec(){    	
    	if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && x < state_x + 40) {
            System.out.println("KEY PRESSED ");
            if(secMap.conMove((x+40)/40, (560-y)/40) && secMap.canMoveDirection((560-y)/40, (x+40)/40)) {
            	x += 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(secMap.conMove((x-40)/40, (560-y)/40) && secMap.canMoveDirection((560-y)/40, (x-40)/40)) {
            	x -= 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(secMap.conMove((x)/40, (520-y)/40) && secMap.canMoveDirection((520-y)/40, (x)/40)) {
            	y += 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(secMap.conMove((x)/40, (600-y)/40) && secMap.canMoveDirection((600-y)/40, (x)/40)) {
            	y -= 40;
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.SPACE)){  
       		secMap.changeOldState();
        	state_x = x;
        	state_y = y;
        	touch = false;
        }
    }
    
    @Override
    public void render(float delta) {
    	state_c = x/40;
    	state_r = (560-y)/40;
    	Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(map == 0) {
			mapFirst();
		} else if(map == 1) {
			mapSec();
		}
        batch.begin();
        batch.draw(HeroImg, x, y);
        font.draw(batch, "LIFE : " + hero.life, 25, 140 );
        font.draw(batch, "STATUS : " , 200, 140 );
        batch.end();
       
        System.out.println(firstMap.stateC + "   " + firstMap.stateR);     
    }
    
    public void mapFirst(){
    	firstMap.stateC = state_x/40;
        firstMap.stateR = (560-state_y)/40;
		firstMapRenderer.render();
		if (createBomb == false) {
			firstMap.randomBomb();
			createBomb = true; 
		} if (firstMap.checkOut(state_x/40, (560-state_y)/40)) {
			map++;
			createBomb = false;
			state_x = 200;
			state_y = 440;
			x = 160;
			y = 440;
			
		} if(firstMap.touchBomb(state_x/40, (560-state_y)/40) && touch == false) {
			hero.life -= 1;
			touch = true;
		} if(hero.life == 0) {
			batch.begin();
	        batch.draw(gameOverImage, 100, 270);
	        batch.end();
	        gameOver = true;
		} if(gameOver == false) {
			updateFirst();
		}
    }
    
    public void mapSec() {
    	secMap.stateC = state_x/40;
        secMap.stateR = (560-state_y)/40;
		secMapRenderer.render();
		System.out.println(x + " " + y + " " + state_x + " " + state_y);
		if (createBomb == false) {
			secMap.randomBomb();
			createBomb = true; 
		} if (secMap.checkOut(state_x/40, (560-state_y)/40)) {
			map++;
			createBomb = false;
			state_x = 200;
			state_y = 440;
		} if(secMap.touchBomb(state_x/40, (560-state_y)/40) && touch == false) {
			hero.life -= 1;
			touch = true;
		} if(hero.life == 0) {
			batch.begin();
	        batch.draw(gameOverImage, 100, 270);
	        batch.end();
	        gameOver = true;
		} if(gameOver == false) {
			updateSec();
		}
    }
}
