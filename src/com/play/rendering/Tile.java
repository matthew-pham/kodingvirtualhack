package com.play.rendering;

public class Tile {

	private Sprite sprite;
	private int x, y;
	
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	
	
}
