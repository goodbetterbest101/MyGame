package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirstMapRenderer {
	private FirstMap firstMap;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture floorImage;
    private Texture oldStateImage;
    private Texture choiceImage;
    private Texture doorImage;
    private Texture bombImage;
 
    public FirstMapRenderer(SpriteBatch batch, FirstMap firstMap) { //constructor
        this.firstMap = firstMap;
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
    	//System.out.println(""+ firstMap.getHeight());
        for(int r = 0; r < firstMap.getHeight(); r++) {
            for(int c = 0; c < firstMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(firstMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(firstMap.hasDoorAt(r, c)) {
                	batch.draw(doorImage, x, y);
                } else if(firstMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(firstMap.hasChoiceRightAt(r, c) || firstMap.hasChoiceUpAt(r, c) || firstMap.hasChoiceDownAt(r, c) ||firstMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(firstMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                } 
            }
        }
        batch.end();
    }

}
