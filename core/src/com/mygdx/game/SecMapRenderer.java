package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SecMapRenderer {
	private SecMap secMap;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture floorImage;
    private Texture oldStateImage;
    private Texture choiceImage;
 
    public SecMapRenderer(SpriteBatch batch, SecMap secMap) { //constructor
        this.secMap = secMap;
        this.batch = batch;
        floorImage = new Texture("floor.png");
        wallImage = new Texture("rockfloor.png");
        oldStateImage = new Texture("wall.png");
        choiceImage = new Texture("wallrock.png");
    }
 
    public void render() {
    	batch.begin();
    	//System.out.println(""+ firstMap.getHeight());
        for(int r = 0; r < secMap.getHeight(); r++) {
            for(int c = 0; c < secMap.getWidth(); c++) {
                int x = c * 40;
                int y = MyGame.HEIGHT - (r * 40) - 40;
 
                if(secMap.hasWallAt(r, c)) {
                    batch.draw(wallImage, x, y);
                } else if(secMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                } else if(secMap.hasChoiceRightAt(r, c) || secMap.hasChoiceUpAt(r, c) || secMap.hasChoiceDownAt(r, c) || secMap.hasChoiceLeftAt(r, c)) {
                    batch.draw(choiceImage, x, y);
                } else if(secMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                }
            }
        }
        batch.end();
    }

}
