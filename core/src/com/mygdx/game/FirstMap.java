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
	private int height;
    private int width;
 
    public FirstMap() {
        height = MAP.length;
        width = MAP[0].length();
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    public boolean hasWallAt(int r, int c) {
        return MAP[r].charAt(c) == '#';
    }
 
    public boolean hasDotAt(int r, int c) {
        return MAP[r].charAt(c) == '.';
    }
    
}