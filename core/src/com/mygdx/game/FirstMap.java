package com.mygdx.game;

import java.util.Random;

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
    int positionBomb;
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
    
    public void randomBomb() {
    	Random randomBomb = new Random();
    	for (int i = 0;i < 5; i++){
    		if(i == 0) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP2[3].setCharAt(positionBomb,'b');
    		} else if(i == 1) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP2[4].setCharAt(positionBomb,'b');
    		} else if(i == 2) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP2[5].setCharAt(positionBomb,'b');
    		} else if(i == 3) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP2[6].setCharAt(positionBomb,'b');
    		} else if(i == 4) {
    			positionBomb = randomBomb.nextInt(5);
    			if(positionBomb < 6) {
    				positionBomb += 3;
    			}
    			MAP2[7].setCharAt(positionBomb,'b');
    		}
    	}
    }
    
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean hasDoorAt(int r, int c) {
        return (MAP2[r].charAt(c) == 'S' || MAP2[r].charAt(c) == 'O');
    }
    
    
    public boolean hasWallAt(int r, int c) {
        return MAP2[r].charAt(c) == '#';
    }
 
    public boolean hasDotAt(int r, int c) {
        return MAP2[r].charAt(c) == '.' || MAP2[r].charAt(c) == 'b';
    }
    
    public boolean hasBombAt(int r, int c) {
        return MAP2[r].charAt(c) == 'B';
    }
    
    public boolean hasOldState(int r, int c) {
        return MAP2[r].charAt(c) == '*';
    }
    
    public boolean hasChoiceRightAt(int r,int c) {
    	boolean right = false;
    	if(stateR == r && stateC + 1 == c) {    //RIGHT
    		right = true;
    	}
    	return right;
    }
    
    public boolean hasChoiceUpAt(int r,int c) {
    	boolean up = false;
    	if(stateR - 1 == r && stateC == c) { 		//UP
    		up = true;
    	}
    	return up;
    }
    
    public boolean hasChoiceDownAt(int r,int c) {
    	boolean down = false;
    	if(stateR + 1 == r && stateC == c) { 		//Down
    		down = true;
    	}
    	return down;
    }
    
    public boolean hasChoiceLeftAt(int r,int c) {
    	boolean left = false;
    	if(stateR == r && stateC - 1 == c) { 		//Left
    		left = true;
    	}
    	return left;
    }
    
    public boolean canMoveDirection(int r ,int c) { 
    	boolean move;
    	move = true;
    	if(stateR == r && stateC + 1 == c) { 	// RIGHT
    		move = true;
    	}
    	else if(stateR - 1 == r && stateC == c) { 		//UP
    		move = true;
    	}
    	else if(stateR + 1 == r && stateC == c) {		//DOWN
    		move = true;
    	}
    	else if(stateR == r && stateC - 1 == c) {		//LEFT
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
    	if(MAP2[stateR].charAt(stateC) == 'b' ){
    		MAP2[stateR].setCharAt(stateC,'B');
    	}else {
    		MAP2[stateR].setCharAt(stateC,'*');
    	}
    }
    
    public boolean touchBomb(int c ,int r) {
    	return MAP2[r].charAt(c) == 'b';
    }
    
    public boolean checkOut(int c ,int r) {
    	return MAP2[r].charAt(c) == 'O';
    }
    
}    
