package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirstMapRenderer {
	private FirstMap firstMap;
    private SpriteBatch batch;
    private GameScreen gameScreen;
    private Texture wallImage;
    private Texture floorImage;
    private Texture oldStateImage;
    private Texture choiceImage;
    private Texture doorImage;
    private Texture bombImage;
    private Texture lifeImage;
    private Texture shieldImage;
    float time = 0;
    int round = 0;
 
    public FirstMapRenderer(SpriteBatch batch, FirstMap firstMap) { //constructor
        this.firstMap = firstMap;
        this.batch = batch;
        floorImage = new Texture("stone2.png");
        wallImage = new Texture("wall2.png");
        oldStateImage = new Texture("after copy.png");
        choiceImage = new Texture("choice.png");
        doorImage = new Texture("door.png");
        bombImage = new Texture("bomb.png");
        lifeImage = new Texture("life.png");
        shieldImage = new Texture("shield.png");
    }
    
    public void renderHint(){
    	for(int r = 0; r < firstMap.getHeight(); r++) {
            for(int c = 0; c < firstMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(firstMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(firstMap.hasDoorAt(r, c)) {
                	batch.draw(doorImage, x, y);
                } else if(firstMap.hasBombHintAt(r, c)) {
                    batch.draw(bombImage, x, y);
                } else if(firstMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(firstMap.hasChoiceRightAt(r, c) || firstMap.hasChoiceUpAt(r, c) || firstMap.hasChoiceDownAt(r, c) ||firstMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(firstMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                } 
            }
        }
    }
    
    public void renderMap(){
    	for(int r = 0; r < firstMap.getHeight(); r++) {
            for(int c = 0; c < firstMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(firstMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(firstMap.hasDoorAt(r, c)) {
                	batch.draw(doorImage, x, y);
                } else if(firstMap.hasBombAt(r, c)) {
                    batch.draw(bombImage, x, y);
                } else if(firstMap.hasLifeAt(r, c)) {
                    batch.draw(lifeImage, x, y);
                } else if(firstMap.hasShieldAt(r, c)) {
                    batch.draw(shieldImage, x, y);
                } else if(firstMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(firstMap.hasChoiceRightAt(r, c) || firstMap.hasChoiceUpAt(r, c) || firstMap.hasChoiceDownAt(r, c) ||firstMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(firstMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                } 
            }
        }
    }
    
    public void render() {
    	time += 0.05;
    	batch.begin();
    	if(time > 4){
    		round++;
    	}
    	if(round == 0){
    		renderHint();
    	} else {
	        renderMap();
    	}
        batch.end();
    }
    
    public void hintBomb(){
    	batch.begin();
    	while(time < 2) {
	        for(int r = 0; r < firstMap.getHeight(); r++) {
	            for(int c = 0; c < firstMap.getWidth(); c++) {
	                int x = c * 40;
	                int y = MyGame.HEIGHT - (r * 40) - 40;
	                
	                if(firstMap.hasBombAt(r, c)) {
	                    batch.draw(bombImage, x, y);
	                }
	            }
	        }
    		batch.draw(bombImage, 100, 100);
	        time += Gdx.graphics.getDeltaTime();
	        
    	}
    	System.out.println(time);
        batch.end();
    }

}
