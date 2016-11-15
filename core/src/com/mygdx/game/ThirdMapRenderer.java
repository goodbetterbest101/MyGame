package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ThirdMapRenderer {
	private ThirdMap thirdMap;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture floorImage;
    private Texture oldStateImage;
    private Texture choiceImage;
    private Texture doorImage;
    private Texture bombImage;
 
    public ThirdMapRenderer(SpriteBatch batch, ThirdMap thirdMap) { //constructor
        this.thirdMap = thirdMap;
        this.batch = batch;
        floorImage = new Texture("stone2.png");
        wallImage = new Texture("wall2.png");
        oldStateImage = new Texture("after copy.png");
        choiceImage = new Texture("choice.png");
        doorImage = new Texture("door.png");
        bombImage = new Texture("bomb.png");
    }
 
    public void render() {
    	batch.begin();
        for(int r = 0; r < thirdMap.getHeight(); r++) {
            for(int c = 0; c < thirdMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(thirdMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(thirdMap.hasDoorAt(r, c)) {
                	batch.draw(doorImage, x, y);
                } else if(thirdMap.hasBombAt(r, c)) {
                    batch.draw(bombImage, x, y);
                } else if(thirdMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(thirdMap.hasChoiceRightAt(r, c) || thirdMap.hasChoiceUpAt(r, c) || thirdMap.hasChoiceDownAt(r, c) || thirdMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(thirdMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                }
            }
        }
        batch.end();
    }

}
