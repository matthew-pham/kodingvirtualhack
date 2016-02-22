package com.play.rendering;

import java.awt.image.BufferedImage;

import com.play.animator.*;

public class Characters1{

	private double x;
	private double y;
	
	private double Yacceleration = 0;
	private double Yvelocity = 0;
	
	private double Xacceleration = 0;
	private double Xvelocity = 0;
	
	private boolean isOnGround = false;
	
	private boolean isPlayer = false;
	
	private Animater animater;
	private PlayerAnimater playerAnimater;
	private DragonAnimatar dragonAnimater;
	
	private Sprite sprite;
	
	private String type;
	
	
	
	public void update() {
		if(playerAnimater !=null) {
			sprite.setImg(PlayerAnimater.getImage(PlayerAnimater.state));
		} else if(type == "Dragon"){
			sprite.setImg(this.dragonAnimater.getImage(dragonAnimater.state));
		}
	}
	
	public Characters1(String path, int x, int y) {
		sprite = new Sprite();
		sprite.init(path);
		this.x = x;
		this.y = y;
		
	}
	
	
	public PlayerAnimater getPlayerAnimater() {
		return playerAnimater;
	}

	public boolean isPlayer() {
		return isPlayer;
	}


	public void setPlayer(boolean isPlayer, PlayerAnimater animater) {
		this.isPlayer = isPlayer;
		if(animater != null) {
		playerAnimater = animater;
		}
	}

	public Sprite getSprite() {
		return sprite;
	}


	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	public double getYacceleration() {
		return Yacceleration;
	}


	public void setYacceleration(double yacceleration) {
		Yacceleration = yacceleration;
	}


	public double getYvelocity() {
		return Yvelocity;
	}


	public void setYvelocity(double yvelocity) {
		Yvelocity = yvelocity;
	}


	public double getXacceleration() {
		return Xacceleration;
	}


	public void setXacceleration(double xacceleration) {
		Xacceleration = xacceleration;
	}


	public double getXvelocity() {
		return Xvelocity;
	}


	public void setXvelocity(double xvelocity) {
		Xvelocity = xvelocity;
	}


	public boolean isOnGround() {
		return isOnGround;
	}


	public void setOnGround(boolean isOnGround) {
		this.isOnGround = isOnGround;
	}


	public Animater getAnimater() {
		return animater;
	}


	public void setAnimater(Animater animater) {
		this.animater = animater;
	}

	
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DragonAnimatar getDragonAnimater() {
		return dragonAnimater;
	}

	public void setDragonAnimater(DragonAnimatar dragonAnimater) {
		this.dragonAnimater = dragonAnimater;
	}
	
	
	
	
}
