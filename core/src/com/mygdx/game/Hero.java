package com.mygdx.game;

public class Hero {
	public int tempX = 0;
	public int tempY = 0;
	Hero (int x ,int y){
		tempX = x;
		tempY = y;
	}
	public void inputTemp(int x,int y){
		tempX = x;
		tempY = y;
	}
	public int sendTempX(){
		return tempX;
	}
	public int sendTempY(){
		return tempY;
	}
}
