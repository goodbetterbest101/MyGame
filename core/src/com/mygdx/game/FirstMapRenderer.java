package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirstMapRenderer {
	private FirstMap firstMap;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture floorImage;
    private Texture oldStateImage;
 
    public FirstMapRenderer(SpriteBatch batch, FirstMap firstMap) { //constructor
        this.firstMap = firstMap;
        this.batch = batch;
        floorImage = new Texture("floor.png");
        wallImage = new Texture("rockfloor.png");
        oldStateImage = new Texture("wall.png");
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
                } else if(firstMap.hasDotAt(r, c)) {
                    batch.draw(floorImage, x, y);
                } else if(firstMap.hasOldState(r, c)) {
                    batch.draw(oldStateImage, x, y);
                }
            }
        }
        batch.end();
    }

}
