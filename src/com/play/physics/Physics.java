package com.play.physics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.play.animator.DragonAnimatar;
import com.play.animator.PlayerAnimater;
import com.play.audio.Sound;
import com.play.input.Input;
import com.play.rendering.Characters1;
public class Physics {	
	
	public static boolean canMove = true;
	
	
	public static ArrayList<Characters1> update(ArrayList<Characters1> characters,double time) {
		
		for(Characters1 c:characters) {
			if(PlayerAnimater.player == null) {
				PlayerAnimater.player = c;
			}
			if(c.getY() >= 395 - c.getSprite().getImg().getHeight()) {
				c.setYvelocity(0);
				c.setYacceleration(0);
				if(c.isPlayer() && canMove) {
					if(Input.isPressed(32)) {
						c.setYvelocity(-50);
					}
				}
			}
			else {
				c.setYacceleration(9.81);
			}
			
			if(c.isPlayer()) {
				if(PlayerAnimater.mana < 200) {
				PlayerAnimater.mana = PlayerAnimater.mana + 0.1f;
				}
				if(Input.isPressed(81) && canMove && PlayerAnimater.mana > 20) {
					PlayerAnimater.mana = PlayerAnimater.mana - 20;
					if(PlayerAnimater.wasRight) {
					PlayerAnimater.changeState("mele_right");
					} else {
						PlayerAnimater.changeState("mele_left");
					}
					canMove = false;
				} else if(Input.isPressed(69) && c.getXvelocity() == 0 && c.getYvelocity() == 0 && PlayerAnimater.mana >= 100 && canMove) {
					PlayerAnimater.changeState("ult");
					PlayerAnimater.mana = PlayerAnimater.mana - 100;
					canMove = false;
				}
				
				if(canMove) {
					if(Input.isPressed(68)) {
						c.setXvelocity(35);
						PlayerAnimater.changeState("walk_right");
						//Sound.playSound(0);
					} else if(Input.isPressed(65)) {
						c.setXvelocity(-35);
						PlayerAnimater.changeState("walk_left");
					} else {
						c.setXvelocity(0);
					}
					
					if(c.getXvelocity() == 0 && c.getYvelocity() == 0 && PlayerAnimater.state != "ult") {
						PlayerAnimater.changeState("idle");
					}

			}
				if(characters.get(1).getX() >= c.getX() && characters.get(1).getX() <= c.getX() + 90 && PlayerAnimater.state.equals("ult") && PlayerAnimater.frameCounter == 50) {
					DragonAnimatar.health = DragonAnimatar.health - 50f;
				}
				if(characters.get(1).getX() >= c.getX() && characters.get(1).getX() <= c.getX() + 90 && PlayerAnimater.state.equals("mele_right") && PlayerAnimater.frameCounter == 50) {
					DragonAnimatar.health = DragonAnimatar.health - 10f;
				}
				if(characters.get(1).getX() >= c.getX() && characters.get(1).getX() <= c.getX() + 90 && PlayerAnimater.state.equals("mele_left") && PlayerAnimater.frameCounter == 50) {
					DragonAnimatar.health = DragonAnimatar.health - 10f;
				}
				
			} else if(c.getType() == "Dragon") {
				
				if(Math.abs(PlayerAnimater.player.getX() - c.getX()) <= 1500 && Math.abs(PlayerAnimater.player.getX() - c.getX()) >= c.getSprite().getImg().getWidth()*2) {
					if(PlayerAnimater.player.getX() > c.getX()) {
//						c.setXvelocity(10);
//						c.getDragonAnimater().wasRight = true;
//						if(c.getDragonAnimater().state !="takeOf_right" && c.getDragonAnimater().state !="fly_right" && c.getDragonAnimater().state != "land_right") {
//							c.getDragonAnimater().changeState("takeOf_right");
//							
//						} else if(c.getDragonAnimater().state =="takeOf_right" && c.getDragonAnimater().frameCounter == 60 ) {
//							c.getDragonAnimater().changeState("fly_right");
//						} else {
//							c.getDragonAnimater().changeState("idle");
//						}
						c.getDragonAnimater().changeState("idle");
						c.getDragonAnimater().wasRight = true;
						c.setXvelocity(10);
					} else {
						c.getDragonAnimater().changeState("idle");
						c.getDragonAnimater().wasRight = false;
						c.setXvelocity(-10);
					}
//					System.out.println(c.getXvelocity() + " " + c.getX());
					
				} else if(Math.abs(PlayerAnimater.player.getX() - c.getX()) <= c.getSprite().getImg().getWidth()*2) {
					c.setXvelocity(0);
					if(PlayerAnimater.player.getX() > c.getX()) {
						c.getDragonAnimater().wasRight = true;

						if(Math.abs(PlayerAnimater.player.getX() - c.getX()) <= 200 && c.getDragonAnimater().state.equals("mele_right") && c.getDragonAnimater().frameCounter <= 77 && PlayerAnimater.player.getY() >  300) {
							PlayerAnimater.health = PlayerAnimater.health - .2f;
						}
						c.getDragonAnimater().changeState("mele_right");
					} else {
						c.getDragonAnimater().wasRight = false;
						if(Math.abs(PlayerAnimater.player.getX() - c.getX()) >=100 && c.getDragonAnimater().state.equals("mele_right") && c.getDragonAnimater().frameCounter <= 77 && PlayerAnimater.player.getY() >  300) {
							PlayerAnimater.health = PlayerAnimater.health - .2f;
						}
						c.getDragonAnimater().changeState("mele_left");
					}
				} else {
					c.setXvelocity(0);
					c.getDragonAnimater().changeState("idle");
				}
				
				//System.out.println(c.getDragonAnimater().state + " " + c.getDragonAnimater().frameCounter);
			}
			
			if(PlayerAnimater.health  < 0 || DragonAnimatar.health < 0) {
				PlayerAnimater.health = 200;
				PlayerAnimater.mana = 200;
				DragonAnimatar.health = 200;
			}
			
			
			c.setYvelocity(c.getYacceleration() * time + c.getYvelocity());
			c.setY((int)(c.getYvelocity() * time + c.getY()));
			c.setXvelocity(c.getXacceleration() * time + c.getXvelocity());
			c.setX((int)(c.getXvelocity() * time + c.getX()));
		}
		
		return characters;
	}
	
}
