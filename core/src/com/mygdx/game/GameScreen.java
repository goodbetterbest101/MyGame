package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
	private ThirdMap thirdMap;
	private ThirdMapRenderer thirdMapRenderer;
	private FourthMap fourthMap;
	private FourthMapRenderer fourthMapRenderer;
	private FifthMap fifthMap;
	private FifthMapRenderer fifthMapRenderer;
	private FirstScreen firstScreen;
	private SecScreen secScreen;
	private Hero hero;
	private BitmapFont font;
	private OrthographicCamera camera;
	private Texture gameOverImage;
	private Sound bomb;
	private Sound foot;
	private Sound life;
	private Sound shield;
	private Music mp3Music; 
	
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
	int screen = 0;
	
    public GameScreen(MyGame myGame) {
        this.myGame = myGame;
        this.batch = myGame.batch;
        this.firstMap = new FirstMap();
        this.hero = new Hero(x,y);
        this.firstMapRenderer = new FirstMapRenderer(myGame.batch,firstMap);
        this.secMap = new SecMap();
        this.secMapRenderer = new SecMapRenderer(myGame.batch,secMap);
        this.thirdMap = new ThirdMap();
        this.thirdMapRenderer = new ThirdMapRenderer(myGame.batch,thirdMap);
        this.fourthMap = new FourthMap();
        this.fourthMapRenderer = new FourthMapRenderer(myGame.batch,fourthMap);
        this.fifthMap = new FifthMap();
        this.fifthMapRenderer = new FifthMapRenderer(myGame.batch,fifthMap);
        firstScreen = new FirstScreen(myGame.batch);
        secScreen = new SecScreen(myGame.batch);
        font = new BitmapFont();
        camera = new OrthographicCamera();
        HeroImg = new Texture("hero.png");
        gameOverImage = new Texture("gameover.png");
        bomb = Gdx.audio.newSound(Gdx.files.internal("Bomb.mp3"));
        foot = Gdx.audio.newSound(Gdx.files.internal("foot.mp3"));
        life = Gdx.audio.newSound(Gdx.files.internal("lifeUp.mp3"));
        shield = Gdx.audio.newSound(Gdx.files.internal("shieldUp.mp3"));
        mp3Music = Gdx.audio.newMusic(Gdx.files.internal("backMu.mp3"));
        mp3Music.setLooping(true);
        mp3Music.setVolume(0.8f);
        mp3Music.play();
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
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x-40)/40, (MyGame.HEIGHT-40-y)/40) && firstMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x-40)/40)) {
            	x -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x)/40, (MyGame.HEIGHT-80-y)/40) && firstMap.canMoveDirection((MyGame.HEIGHT-80-y)/40, (x)/40)) {
            	y += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(firstMap.conMove((x)/40, (MyGame.HEIGHT-y)/40) && firstMap.canMoveDirection((MyGame.HEIGHT-y)/40, (x)/40)) {
            	y -= 40;
            	foot.play(0.75f);
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
            if(secMap.conMove((x+40)/40, (MyGame.HEIGHT-40-y)/40) && secMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x+40)/40)) {
            	x += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(secMap.conMove((x-40)/40, (MyGame.HEIGHT-40-y)/40) && secMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x-40)/40)) {
            	x -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(secMap.conMove((x)/40, (MyGame.HEIGHT-80-y)/40) && secMap.canMoveDirection((MyGame.HEIGHT-80-y)/40, (x)/40)) {
            	y += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(secMap.conMove((x)/40, (MyGame.HEIGHT-y)/40) && secMap.canMoveDirection((MyGame.HEIGHT-y)/40, (x)/40)) {
            	y -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.SPACE)){  
       		secMap.changeOldState();
        	state_x = x;
        	state_y = y;
        	touch = false;
        }
    }
    
    public void updateThird(){    	
    	if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && x < state_x + 40) {
            System.out.println("KEY PRESSED ");
            if(thirdMap.conMove((x+40)/40, (MyGame.HEIGHT-40-y)/40) && thirdMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x+40)/40)) {
            	x += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(thirdMap.conMove((x-40)/40, (MyGame.HEIGHT-40-y)/40) && thirdMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x-40)/40)) {
            	x -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(thirdMap.conMove((x)/40, (MyGame.HEIGHT-80-y)/40) && thirdMap.canMoveDirection((MyGame.HEIGHT-80-y)/40, (x)/40)) {
            	y += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(thirdMap.conMove((x)/40, (MyGame.HEIGHT-y)/40) && thirdMap.canMoveDirection((MyGame.HEIGHT-y)/40, (x)/40)) {
            	y -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.SPACE)){  
        	thirdMap.changeOldState();
        	state_x = x;
        	state_y = y;
        	touch = false;
        }
    }
    
    public void updateFourth(){    	
    	if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && x < state_x + 40) {
            System.out.println("KEY PRESSED ");
            if(fourthMap.conMove((x+40)/40, (MyGame.HEIGHT-40-y)/40) && fourthMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x+40)/40)) {
            	x += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(fourthMap.conMove((x-40)/40, (MyGame.HEIGHT-40-y)/40) && fourthMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x-40)/40)) {
            	x -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(fourthMap.conMove((x)/40, (MyGame.HEIGHT-80-y)/40) && fourthMap.canMoveDirection((MyGame.HEIGHT-80-y)/40, (x)/40)) {
            	y += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(fourthMap.conMove((x)/40, (MyGame.HEIGHT-y)/40) && fourthMap.canMoveDirection((MyGame.HEIGHT-y)/40, (x)/40)) {
            	y -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.SPACE)){  
        	fourthMap.changeOldState();
        	state_x = x;
        	state_y = y;
        	touch = false;
        }
    }
    
    public void updateFifth(){    	
    	if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && x < state_x + 40) {
            System.out.println("KEY PRESSED ");
            if(fifthMap.conMove((x+40)/40, (MyGame.HEIGHT-40-y)/40) && fifthMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x+40)/40)) {
            	x += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.LEFT) && x > state_x - 40) {
            System.out.println("KEY PRESSED ");
            if(fifthMap.conMove((x-40)/40, (MyGame.HEIGHT-40-y)/40) && fifthMap.canMoveDirection((MyGame.HEIGHT-40-y)/40, (x-40)/40)) {
            	x -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.UP) && y < state_y + 40 ) {
            System.out.println("KEY PRESSED ");
            if(fifthMap.conMove((x)/40, (MyGame.HEIGHT-80-y)/40) && fifthMap.canMoveDirection((MyGame.HEIGHT-80-y)/40, (x)/40)) {
            	y += 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.DOWN) && y > state_y - 40 ) {
            System.out.println("KEY PRESSED ");
            if(fifthMap.conMove((x)/40, (MyGame.HEIGHT-y)/40) && fifthMap.canMoveDirection((MyGame.HEIGHT-y)/40, (x)/40)) {
            	y -= 40;
            	foot.play(0.75f);
            }
        } else if (Gdx.input.isKeyJustPressed(Keys.SPACE)){  
        	fifthMap.changeOldState();
        	state_x = x;
        	state_y = y;
        	touch = false;
        }
    }
    
    
    @Override
    public void render(float delta) {
    	state_c = x/40;
    	state_r = (MyGame.HEIGHT-40-y)/40;
    	if(firstScreen.thisScreen == true){
    		firstScreen.render();
    	} else if(secScreen.thisScreen == true){
    		secScreen.render();
    	}else {
	    	Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			if(map == 0) {
				mapFirst();
			} else if(map == 1) {
				mapSec();
			} else if(map == 2) {
				mapThird();
			} else if(map == 3) {
				mapFourth();
			} else if(map == 4) {
				mapFifth();
			} 
			
	        batch.begin();
	        batch.draw(HeroImg, x, y);
	        font.draw(batch, "LIFE : " + hero.life, 125, 140 );
	        font.draw(batch, "SHIELD : " + hero.shield, 250, 140 );
	        font.draw(batch, "MAP : " + (map+1) , 390, 140 );
	        batch.end();
	       
	        System.out.println(firstMap.stateC + "   " + firstMap.stateR + "   " + firstMapRenderer.time);   
    	}
    }
    
    public void touchBomb(){
    	if(hero.shield > 0){
			hero.shield -= 1;
		} else {
			hero.life -= 1;
		}
		bomb.play(0.6f);
		touch = true;
    }
    
    public void touchLife(){
    	hero.life += 1;
		life.play(0.6f);
		touch = true;
    }
    
    public void touchShield(){
    	hero.shield += 1;
		shield.play(0.6f);
		touch = true;
    }
    
    public void mapFirst(){
    	firstMap.stateC = state_x/40;
        firstMap.stateR = (MyGame.HEIGHT-40-state_y)/40;
		firstMapRenderer.render();
		if (createBomb == false) {
			firstMap.randomBomb();
			createBomb = true; 
		} if (firstMap.checkOut(state_x/40, (MyGame.HEIGHT-40-state_y)/40)) {
			map++;
			createBomb = false;
			state_x = 200;
			state_y = 440;
			x = 160;
			y = 440;
		} if(firstMap.touchBomb(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchBomb();
		} if(firstMap.touchLife(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchLife();
		} if(firstMap.touchShield(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchShield();
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
        secMap.stateR = (MyGame.HEIGHT-40-state_y)/40;
		secMapRenderer.render();
		//System.out.println(x + " " + y + " " + state_x + " " + state_y);
		if (createBomb == false) {
			secMap.randomBomb();
			createBomb = true; 
		} if (secMap.checkOut(state_x/40, (MyGame.HEIGHT-40-state_y)/40)) {
			map++;
			createBomb = false;
			state_x = 160;
			state_y = 480;
			x = 120;
			y = 480;
		} if(secMap.touchBomb(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchBomb();
		} if(secMap.touchLife(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchLife();
		} if(secMap.touchShield(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchShield();
		} if(hero.life == 0) {
			batch.begin();
	        batch.draw(gameOverImage, 100, 270);
	        batch.end();
	        gameOver = true;
		} if(gameOver == false) {
			updateSec();
		}
    }
    
    public void mapThird() {
    	thirdMap.stateC = state_x/40;
        thirdMap.stateR = (MyGame.HEIGHT-40-state_y)/40;
		thirdMapRenderer.render();
		System.out.println(x + " " + y + " " + state_x + " " + state_y);
		if (createBomb == false) {
			thirdMap.randomBomb();
			createBomb = true; 
		} if (thirdMap.checkOut(state_x/40, (MyGame.HEIGHT-40-state_y)/40)) {
			map++;
			createBomb = false;
			state_x = 160;
			state_y = 480;
			x = 120;
			y = 480;
		} if(thirdMap.touchBomb(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchBomb();
			System.out.println("BOMBBB !!!");
		} if(thirdMap.touchLife(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchLife();
		} if(thirdMap.touchShield(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchShield();
		} if(hero.life == 0) {
			batch.begin();
	        batch.draw(gameOverImage, 100, 270);
	        batch.end();
	        gameOver = true;
		} if(gameOver == false) {
			updateThird();
		}
    }
    
    public void mapFourth() {
    	fourthMap.stateC = state_x/40;
        fourthMap.stateR = (MyGame.HEIGHT-40-state_y)/40;
		fourthMapRenderer.render();
		System.out.println(x + " " + y + " " + state_x + " " + state_y);
		if (createBomb == false) {
			fourthMap.randomBomb();
			createBomb = true; 
		} if (fourthMap.checkOut(state_x/40, (MyGame.HEIGHT-40-state_y)/40)) {
			map++;
			createBomb = false;
			state_x = 120;
			state_y = 520;
			x = 80;
			y = 520;
		} if(fourthMap.touchBomb(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchBomb();
			System.out.println("BOMBBB !!!");
		} if(fourthMap.touchLife(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchLife();
		} if(fourthMap.touchShield(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchShield();
		} if(hero.life == 0) {
			batch.begin();
	        batch.draw(gameOverImage, 100, 270);
	        batch.end();
	        gameOver = true;
		} if(gameOver == false) {
			updateFourth();
		}
    }
    public void mapFifth() {
    	fifthMap.stateC = state_x/40;
        fifthMap.stateR = (MyGame.HEIGHT-40-state_y)/40;
        fifthMapRenderer.render();
		System.out.println(x + " " + y + " " + state_x + " " + state_y);
		if (fifthMap.checkOut(state_x/40, (MyGame.HEIGHT-40-state_y)/40)) {
			map++;
			createBomb = false;
			state_x = 160;
			state_y = 480;
			x = 120;
			y = 480;
		} if(fifthMap.touchBomb(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchBomb();
			System.out.println("BOMBBB !!!");
		} if(fifthMap.touchLife(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchLife();
		} if(fifthMap.touchShield(state_x/40, (MyGame.HEIGHT-40-state_y)/40) && touch == false) {
			touchShield();
		} if(hero.life == 0) {
			batch.begin();
	        batch.draw(gameOverImage, 100, 270);
	        batch.end();
	        gameOver = true;
		} if(gameOver == false) {
			updateFifth();
		}
    }
}

