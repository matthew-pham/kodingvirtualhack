package com.play.animator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.play.engine.Engine;
import com.play.physics.Physics;
import com.play.rendering.Characters1;

public class PlayerAnimater extends Animater{
	
	public static Characters1 player;

	private static ArrayList<BufferedImage> walk_right = new ArrayList<BufferedImage>(4);
	private static ArrayList<BufferedImage> walk_left = new ArrayList<BufferedImage>(4);
	private static ArrayList<BufferedImage> mele_right = new ArrayList<BufferedImage>(6);
	private static ArrayList<BufferedImage> mele_left = new ArrayList<BufferedImage>(6);
	private static ArrayList<BufferedImage> ult = new ArrayList<BufferedImage>(15);
	private static ArrayList<BufferedImage> idle = new ArrayList<BufferedImage>(2);
	

	public static int frameCounter;
	public static String state;
	
	public static float health = 200;
	public static float mana = 200;
	
	public static boolean wasRight = true;
	
	public static void init() {
		try {
			
			
			walk_right.add(ImageIO.read(new File("res\\Player\\walk_right\\walk1.png")));
			walk_right.add(ImageIO.read(new File("res\\Player\\walk_right\\walk2.png")));
			walk_right.add(ImageIO.read(new File("res\\Player\\walk_right\\walk3.png")));
			walk_right.add(ImageIO.read(new File("res\\Player\\walk_right\\walk4.png")));
			
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk1.png")));
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk2.png")));
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk3.png")));
			walk_left.add(ImageIO.read(new File("res\\Player\\walk_left\\walk4.png")));
			
			idle.add(ImageIO.read(new File("res\\Player\\idle\\idle_right.png")));
			idle.add(ImageIO.read(new File("res\\Player\\idle\\idle_left.png")));
			
			mele_right.add(ImageIO.read(new File("res\\Player\\mele_right\\mele1.png")));
			mele_right.add(ImageIO.read(new File("res\\Player\\mele_right\\mele2.png")));
			mele_right.add(ImageIO.read(new File("res\\Player\\mele_right\\mele3.png")));
			mele_right.add(ImageIO.read(new File("res\\Player\\mele_right\\mele4.png")));
			mele_right.add(ImageIO.read(new File("res\\Player\\mele_right\\mele5.png")));
			mele_right.add(ImageIO.read(new File("res\\Player\\mele_right\\mele6.png")));
			
			mele_left.add(ImageIO.read(new File("res\\Player\\mele_left\\mele1.png")));
			mele_left.add(ImageIO.read(new File("res\\Player\\mele_left\\mele2.png")));
			mele_left.add(ImageIO.read(new File("res\\Player\\mele_left\\mele3.png")));
			mele_left.add(ImageIO.read(new File("res\\Player\\mele_left\\mele4.png")));
			mele_left.add(ImageIO.read(new File("res\\Player\\mele_left\\mele5.png")));
			mele_left.add(ImageIO.read(new File("res\\Player\\mele_left\\mele6.png")));
			
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
	
	public static BufferedImage getImage(String state) {
		switch(state) {
		case "walk_right": wasRight = true;if(frameCounter == 44) {frameCounter=0;}return walk_right.get((int)((frameCounter++)/11));
		case "walk_left": wasRight = false;if(frameCounter == 44) {frameCounter=0;}return walk_left.get((int)((frameCounter++)/11));
		case "mele_right": wasRight = true;if(frameCounter == 54) {frameCounter=0; state = "idle"; Physics.canMove = true;}return mele_right.get((int)((frameCounter++)/9));
		case "ult":if(frameCounter == 105) {frameCounter=0;changeState("idle");Physics.canMove = true;};
		System.out.println(state + " " + frameCounter);
		if(frameCounter == 10) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 5);};
		if(frameCounter == 20) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() - 16); };
		if(frameCounter == 25) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() - 11); };
		if(frameCounter == 35) { Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 3);};
		if(frameCounter==100) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 19);}
		
		return ult.get((int)((frameCounter++)/5));
		case "mele_left": wasRight = false;if(frameCounter == 54) {
			frameCounter=0; ; Physics.canMove = true;}
		if(frameCounter == 18) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() - 39);};
		if(frameCounter == 27) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() - 24);};
		if(frameCounter == 36) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 24);};
		if(frameCounter == 45) {Engine.chars.get(0).setX(Engine.chars.get(0).getX() + 39);};
		return mele_left.get((int)((frameCounter++)/9));

		default: if(wasRight) {return idle.get(0);} else {return idle.get(1);}
		}
	}
	
	public static void changeState(String state) {
		if(!state.equals(PlayerAnimater.state)) {
			PlayerAnimater.state = state;
			frameCounter = 0;
		}

	}
	
	
}
