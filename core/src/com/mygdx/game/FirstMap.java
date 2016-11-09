package com.mygdx.game;

public class FirstMap {
	private String[] MAP = new String [] {
			"###############",
			"###############",
			"###############",
			"####S.....#####",
			"#####.....#####",
			"#####.....#####",
			"#####.....#####",
			"#####.....O####",
			"###############",
			"###############",
			"###############",
    };
	
	private StringBuilder MAP2[]; 
	private int height;
    private int width;
    int stateC = 0;
    int stateR = 0;
 
    public FirstMap() {
        height = MAP.length;
        width = MAP[0].length();
        
        MAP2 = new StringBuilder[11];
        MAP2[0] = new StringBuilder("###############");
        MAP2[1] = new StringBuilder("###############");
        MAP2[2] = new StringBuilder("###############");
        MAP2[3] = new StringBuilder("####S.....#####");
        MAP2[4] = new StringBuilder("#####.....#####");
        MAP2[5] = new StringBuilder("#####.....#####");
        MAP2[6] = new StringBuilder("#####.....#####");
        MAP2[7] = new StringBuilder("#####.....O####");
        MAP2[8] = new StringBuilder("###############");
        MAP2[9] = new StringBuilder("###############");
        MAP2[10] = new StringBuilder("###############");
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    public boolean hasWallAt(int r, int c) {
        return MAP2[r].charAt(c) == '#';
    }
 
    public boolean hasDotAt(int r, int c) {
        return MAP2[r].charAt(c) == '.';
    }
    
    public boolean hasOldState(int r, int c) {
        return MAP2[r].charAt(c) == '*';
    }
    
    public boolean hasChoiceUpAt(int r,int c) {
    	boolean up = false;
    	if(stateR == r && stateC + 1 == c) { 
    		up = true;
    	}
    	return up;
    }
    
    public boolean hasChoiceDownAt(int r,int c) {
    	boolean down = false;
    	if(stateR == r && stateC + 1 == c) { 
    		down = true;
    	}
    	return down;
    }
    
    public boolean canMoveDirection(int r ,int c) { 
    	boolean move;
    	move = true;
    	if(stateR == r && stateC + 1 == c) {
    		move = true;
    	}
    	else if(stateR - 1 == r && stateC == c) {
    		move = true;
    	}
    	else if(stateR + 1 == r && stateC == c) {
    		move = true;
    	}
    	else if(stateR == r && stateC - 1 == c) {
    		move = true;
    	}
    	else if(stateR == r && stateC == c) {
    		move = true;
    	}
    	else {
    		move = false;
    	}
    	return move;
    }
    public boolean conMove(int c, int r){
    	boolean move;
    	move = true;
    	if(MAP2[r].charAt(c) == '#' || MAP2[r].charAt(c) == '*')	{
    		move = false;
    	}
    	return move;
    }
    
    public void changeOldState() {
    	MAP2[stateR].setCharAt(stateC,'*');
    }
    
}