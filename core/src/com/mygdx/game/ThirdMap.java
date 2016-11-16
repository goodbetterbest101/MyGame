package com.mygdx.game;

import java.util.Random;

public class ThirdMap {
	private StringBuilder MAP[]; 
	private int height;
    private int width;
    int stateC = 0;
    int stateR = 0;
    int positionBomb;
    public ThirdMap() {
        
        MAP = new StringBuilder[11];
        MAP[0] = new StringBuilder("###############");
        MAP[1] = new StringBuilder("###############");
        MAP[2] = new StringBuilder("###S..u....####");
        MAP[3] = new StringBuilder("####.......####");
        MAP[4] = new StringBuilder("####...l...####");
        MAP[5] = new StringBuilder("####.......####");
        MAP[6] = new StringBuilder("####l....u.####");
        MAP[7] = new StringBuilder("####.......####");
        MAP[8] = new StringBuilder("####...l...O###");
        MAP[9] = new StringBuilder("###############");
        MAP[10] = new StringBuilder("###############");
        height = MAP.length;
        width = MAP[0].length();
    }
    
    public void randomBomb() {
    	Random randomBomb = new Random();
    	for (int i = 0; i < 5; i++){
    		if(i == 0) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP[3].setCharAt(positionBomb,'b');
    		} else if(i == 1) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP[4].setCharAt(positionBomb,'b');
    		} else if(i == 2) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP[5].setCharAt(positionBomb,'b');
    		} else if(i == 3) {
    			positionBomb = randomBomb.nextInt(8)+2;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP[6].setCharAt(positionBomb,'b');
    		} else if(i == 4) {
    			positionBomb = randomBomb.nextInt(7)+1;
    			if(positionBomb < 6) {
    				positionBomb += 4;
    			}
    			MAP[7].setCharAt(positionBomb,'b');
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
        return (MAP[r].charAt(c) == 'S' || MAP[r].charAt(c) == 'O');
    }
    
    public boolean hasBombAt(int r, int c) {
        return MAP[r].charAt(c) == 'B';
    }
    
    public boolean hasWallAt(int r, int c) {
        return MAP[r].charAt(c) == '#';
    }
 
    public boolean hasDotAt(int r, int c) {
        return MAP[r].charAt(c) == '.' || MAP[r].charAt(c) == 'b' || MAP[r].charAt(c) == 'l' || MAP[r].charAt(c) == 'u';
    }
    
    public boolean hasOldState(int r, int c) {
        return MAP[r].charAt(c) == '*';
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
    	if(MAP[r].charAt(c) == '#' || MAP[r].charAt(c) == '*')	{
    		move = false;
    	}
    	return move;
    }
    
    public void changeOldState() {
    	if(MAP[stateR].charAt(stateC) == 'b' ){
    		MAP[stateR].setCharAt(stateC,'B');
    	} else {
    		MAP[stateR].setCharAt(stateC,'*');
    	}
    }
    
    public boolean touchBomb(int c ,int r) {
    	return MAP[r].charAt(c) == 'b';
    }
    
    public boolean touchLife(int c ,int r) {
    	return MAP[r].charAt(c) == 'l';
    }
    
    public boolean touchShield(int c ,int r) {
    	return MAP[r].charAt(c) == 'u';
    }
    
    public boolean checkOut(int c ,int r) {
    	return MAP[r].charAt(c) == 'O';
    }
}