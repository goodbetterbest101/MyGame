package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FifthMapRenderer {
	private FifthMap fifthMap;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture floorImage;
    private Texture oldStateImage;
    private Texture choiceImage;
    private Texture doorImage;
    private Texture bombImage;
    private Texture lifeImage;
    private Texture shieldImage;
 
    public FifthMapRenderer(SpriteBatch batch, FifthMap fifthMap) { //constructor
        this.fifthMap = fifthMap;
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
 
    public void render() {
    	batch.begin();
        for(int r = 0; r < fifthMap.getHeight(); r++) {
            for(int c = 0; c < fifthMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(fifthMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(fifthMap.hasDoorAt(r, c)) {
                	batch.draw(doorImage, x, y);
                } else if(fifthMap.hasBombAt(r, c)) {
                    batch.draw(bombImage, x, y);
                } else if(fifthMap.hasLifeAt(r, c)) {
                    batch.draw(lifeImage, x, y);
                } else if(fifthMap.hasShieldAt(r, c)) {
                    batch.draw(shieldImage, x, y);
                } else if(fifthMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(fifthMap.hasChoiceRightAt(r, c) || fifthMap.hasChoiceUpAt(r, c) || fifthMap.hasChoiceDownAt(r, c) || fifthMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(fifthMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                }
            }
        }
        batch.end();
    }

}
