package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FourthMapRenderer {
	private FourthMap fourthMap;
    private SpriteBatch batch;
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
 
    public FourthMapRenderer(SpriteBatch batch, FourthMap fourthMap) { //constructor
        this.fourthMap = fourthMap;
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
    	for(int r = 0; r < fourthMap.getHeight(); r++) {
            for(int c = 0; c < fourthMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(fourthMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(fourthMap.hasDoorAt(r, c)) {
                	batch.draw(doorImage, x, y);
                } else if(fourthMap.hasBombHintAt(r, c)) {
                    batch.draw(bombImage, x, y);
                } else if(fourthMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(fourthMap.hasChoiceRightAt(r, c) || fourthMap.hasChoiceUpAt(r, c) || fourthMap.hasChoiceDownAt(r, c) || fourthMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(fourthMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                }
            }
        }
    }
    
    public void renderMap(){
    	for(int r = 0; r < fourthMap.getHeight(); r++) {
            for(int c = 0; c < fourthMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(fourthMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(fourthMap.hasDoorAt(r, c)) {
                	batch.draw(doorImage, x, y);
                } else if(fourthMap.hasBombAt(r, c)) {
                    batch.draw(bombImage, x, y);
                } else if(fourthMap.hasLifeAt(r, c)) {
                    batch.draw(lifeImage, x, y);
                } else if(fourthMap.hasShieldAt(r, c)) {
                    batch.draw(shieldImage, x, y);
                } else if(fourthMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(fourthMap.hasChoiceRightAt(r, c) || fourthMap.hasChoiceUpAt(r, c) || fourthMap.hasChoiceDownAt(r, c) || fourthMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(fourthMap.hasDotAt(r, c)) {
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

}
