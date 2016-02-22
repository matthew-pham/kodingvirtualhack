package com.play.animator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.play.engine.Engine;
import com.play.physics.Physics;
import com.play.rendering.Characters1;

public class DragonAnimatar extends Animater{
	
	public static Characters1 dragon;

	private static ArrayList<BufferedImage> takeOf_right = new ArrayList<BufferedImage>(3);
	private static ArrayList<BufferedImage> fly_right = new ArrayList<BufferedImage>(3);
	private static ArrayList<BufferedImage> land_right = new ArrayList<BufferedImage>(2);
	private static ArrayList<BufferedImage> walk_left = new ArrayList<BufferedImage>(4);
	private static ArrayList<BufferedImage> mele_right = new ArrayList<BufferedImage>(6);
	private static ArrayList<BufferedImage> mele_left = new ArrayList<BufferedImage>(6);
	private static ArrayList<BufferedImage> ult = new ArrayList<BufferedImage>(15);
	private static ArrayList<BufferedImage> idle = new ArrayList<BufferedImage>(2);
	
	public static float health = 200;
	

	public  int frameCounter;
	public String state;
	
	public boolean wasRight = true;
	
	public void init() {
		try {
			
			System.out.println("INIT");
			
			takeOf_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly1.png")));
			takeOf_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly2.png")));
			takeOf_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly3.png")));
			
			fly_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly4.png")));
			fly_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly5.png")));
			fly_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly6.png")));
			
			land_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly7.png")));
			land_right.add(ImageIO.read(new File("res\\Dragon\\fly_right\\fly8.png")));
			
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk1.png")));
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk2.png")));
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk3.png")));
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk4.png")));
			
			idle.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_right.png")));
			idle.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_left.png")));
			
			mele_right.add(ImageIO.read(new File("res\\Dragon\\mele_right\\mele1.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\mele_right\\mele2.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\mele_right\\mele3.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\mele_right\\mele4.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\mele_right\\mele5.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\mele_right\\mele3.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_right.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_right.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_right.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_right.png")));
			mele_right.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_right.png")));
			
			mele_left.add(ImageIO.read(new File("res\\Dragon\\mele_left\\mele1.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\mele_left\\mele2.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\mele_left\\mele3.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\mele_left\\mele4.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\mele_left\\mele5.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\mele_left\\mele3.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_left.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_left.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_left.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_left.png")));
			mele_left.add(ImageIO.read(new File("res\\Dragon\\idle\\idle_left.png")));
			
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult1.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult2.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult3.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult4.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult5.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult6.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult7.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult8.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult9.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult9.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult9.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult9.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult9.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult9.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult10.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult11.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult12.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult13.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult14.png")));
			ult.add(ImageIO.read(new File("res\\Player\\ult\\ult15.png")));
			ult.add(ImageIO.read(new File("res\\Player\\idle\\idle_right.png")));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frameCounter = 0;
		state = "idle";
	}
	
	public BufferedImage getImage(String state) {
		switch(state) {
		case "takeOf_right": wasRight = true;if(frameCounter == 60) {frameCounter=0;}return takeOf_right.get((int)((frameCounter++)/20));
		case "fly_right": wasRight = true;if(frameCounter == 60) {frameCounter=0;}return fly_right.get((int)((frameCounter++)/20));
		case "land_right": wasRight = true;if(frameCounter == 22) {frameCounter=0;}return land_right.get((int)((frameCounter++)/11));
		case "walk_left": wasRight = false;if(frameCounter == 44) {frameCounter=0;}return walk_left.get((int)((frameCounter++)/11));
		case "mele_right": wasRight = true;if(frameCounter == 99) {frameCounter=0; state = "idle"; Physics.canMove = true;}return mele_right.get((int)((frameCounter++)/9));
		case "ult":if(frameCounter == 105) {frameCounter=0;changeState("idle");Physics.canMove = true;};
		//System.out.println(state + " " + frameCounter);
//		if(frameCounter == 10) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 5);};
//		if(frameCounter == 20) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() - 16); };
//		if(frameCounter == 25) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() - 11); };
//		if(frameCounter == 35) { Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 3);};
//		if(frameCounter==100) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 19);}
		
		return ult.get((int)((frameCounter++)/5));
		case "mele_left": wasRight = false;if(frameCounter == 99) {
			frameCounter=0; ; Physics.canMove = true;}
//		if(frameCounter == 18) {dragon.setX(dragon.getX() - 40);};
//		if(frameCounter == 27) {dragon.setX(dragon.getX() - 40);};
//		if(frameCounter == 36) {dragon.setX(dragon.getX() + 40);};
//		if(frameCounter == 45) {dragon.setX(dragon.getX() + 40);};
		return mele_left.get((int)((frameCounter++)/9));

		default: if(wasRight) {return idle.get(0);} else {return idle.get(1);}
		}
	}
	
	public void changeState(String state) {
		if(!state.equals(this.state)) {
			this.state = state;
			frameCounter = 0;
		}

	}
	
	
}
