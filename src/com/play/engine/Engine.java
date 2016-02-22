package com.play.engine;

import java.applet.Applet;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JPanel;

import com.play.animator.DragonAnimatar;
import com.play.animator.PlayerAnimater;
import com.play.audio.Sound;
import com.play.input.Input;
import com.play.main.Scheduler;
import com.play.physics.Physics;
import com.play.rendering.*;

public class Engine extends JApplet{
	
	public static ArrayList<Characters1> chars;

	
	public static int width = 768;
	public static int height = 512;
	
	public static JPanel pane;
	
	private static BufferedImage doubleBuffer;
	private static Graphics graphics;
	
	private static BufferedImage tripleBuffer;
	private static Graphics graphics2;
	
	public static Engine engine;
	
	private static long TotalTime;
	
	private Scheduler scheduler;
	
	private ArrayList<Sprite> tiles;

	public void init() {
		pane = new JPanel();
		Input input = new Input();
		//input.start();
		pane.addKeyListener(input);
		input.start();
		this.setContentPane(pane);
		this.setSize(width, height);
	  chars = new ArrayList<Characters1>();
		chars.add(new Characters1("res\\character.png",100,100));
		chars.get(0).setPlayer(true, new PlayerAnimater());
		chars.add(new Characters1("res\\character.png",100,100));
		chars.get(1).setType("Dragon");
		chars.get(1).setDragonAnimater(new DragonAnimatar());
		chars.get(1).getDragonAnimater().init();
		DragonAnimatar.dragon = chars.get(1);
		PlayerAnimater.init();
		Rendering.init();
		doubleBuffer = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		tripleBuffer = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = doubleBuffer.getGraphics();
		graphics2 = tripleBuffer.getGraphics();
		pane.requestFocusInWindow();
		Scheduler.engine = this;
		scheduler = new Scheduler();
		scheduler.init();
		scheduler.start();
		Sound.init();
		tiles = Rendering.genScreen();

	}
	
	  public void paint ( Graphics gr )
	  { 
		  //scheduler.gr = gr;
//		  StartTime = System.nanoTime();
//
//		  //System.out.println((StartTime - LastTime)/1000000000d);
//		  graphics.drawString(String.valueOf(1000000000d/(StartTime - LastTime)), width-100,20 );
//		  //System.out.println(chars.get(0).getY());
//
//		  TotalTime = TotalTime + StartTime - LastTime;
//		  LastTime = StartTime;
//		  System.out.println(TotalTime);
		  	for(Characters1 c: chars) {
		  		c.update();
		  	}
		  		
			  
			  Rendering.drawTiles(graphics, tiles);
			  chars = Physics.update(chars, (Scheduler.DeltaTime)/1000000000d);
			 // System.out.println(Scheduler.DeltaTime);
			  graphics = Rendering.drawCharacters(graphics, chars);
			  graphics = Rendering.drawHUD(graphics, (int) PlayerAnimater.health);
			  //System.out.println(chars.get(0).getY());
			  graphics2.drawImage(doubleBuffer, 0, 0, null);
			  scheduler.gr = gr;
			  gr.drawImage(tripleBuffer, 0, 0, null);
			 // Thread.yield();
			 // System.out.println(Scheduler.needsToUpdate);
			  this.repaint(1000, 0, 0, width, height);
			 // Rendering.clearScreen(graphics, width, height);
			  //System.exit(0);
	  }
	
	
}
