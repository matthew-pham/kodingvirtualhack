package com.play.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.play.engine.Engine;
import com.play.physics.Physics;
import com.play.rendering.Rendering;

public class Scheduler extends Thread{
	
	public Graphics gr;
	private long TotalTime;
	private long StartTime;
	private long LastTime;
	public static Engine engine;
	public static double DeltaTime;
	public static boolean needsToUpdate = true;
	
	private final static  int FPS = 10;

	public void init() {
		StartTime = System.nanoTime();
		LastTime = System.nanoTime();
		gr = new BufferedImage(1,1, 1).getGraphics();

	}
	
	@Override
	public void run() {
		while(true) {
		
		 StartTime = System.nanoTime();

		  //System.out.println((StartTime - LastTime)/1000000000d);
		 // graphics.drawString(String.valueOf(1000000000d/(StartTime - LastTime)), width-100,20 );
		  //System.out.println(chars.get(0).getY());

		  TotalTime = TotalTime + StartTime - LastTime;

		  LastTime = StartTime;
		 // System.out.println("in run");
		  if(TotalTime > (1000000000l/FPS)){
			  DeltaTime = TotalTime;
			  TotalTime = 0;
			  needsToUpdate = true;
			  engine.paint(gr);
		  }
		}
	}
	
}
