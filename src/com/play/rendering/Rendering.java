package com.play.rendering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.imageio.ImageIO;

import com.play.animator.DragonAnimatar;
import com.play.animator.PlayerAnimater;
import com.play.engine.Engine;

public class Rendering {
	
	private static Sprite white;
	public static BufferedImage screen;
	public static ArrayList<Sprite> Tiles;
	
	
	public static void init() {
		white = new Sprite();
		white.init("res\\white.png");
		try {Rendering.screen = ImageIO.read(new File("res\\maps\\map1.png"));} catch (IOException e) {e.printStackTrace();}
		Tiles = new ArrayList<Sprite>();
		Tiles.add((new Sprite()).init("res\\tiles\\grass1.png"));
		Tiles.add((new Sprite()).init("res\\tiles\\dirt1.png"));
		Tiles.add((new Sprite()).init("res\\tiles\\sky1.png"));
		Tiles.add((new Sprite()).init("res\\tiles\\cave1.png"));
		Tiles.add((new Sprite()).init("res\\tiles\\plant1.png"));
	}
	
	public static Graphics drawCharacters(Graphics gr, ArrayList<Characters1> chars) {
		Collections.reverse(chars);
		for(Characters1 c:  chars) {
			gr.drawImage((c.getSprite().getImg()), (int)c.getX(),(int) c.getY(), null);
			//System.out.println(c.getY());
		}
		return gr;
	}
	
	public static BufferedImage resize(BufferedImage img, int width, int height) {
		BufferedImage resized = new BufferedImage(width, height, img.getType());
		Graphics2D g = resized.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img, 0, 0, width, height, 0, 0, img.getWidth(),
		    img.getHeight(), null);
		g.dispose();
		return resized;
	}
	
	public static Graphics clearScreen(Graphics gr,int width, int height) {
		gr.drawImage(white.getImg(), 0, 0, null);
		return gr;
	}
	
	public static Graphics drawHUD(Graphics gr, int health) {
		gr.setColor(Color.BLACK);
		gr.drawRect(18, 18, health+1, 52);
		gr.setColor(Color.GREEN);
		gr.fillRect(19, 19, health, 51);
		
		gr.setColor(Color.BLACK);
		gr.drawRect(18, 78, (int) (PlayerAnimater.mana+1), 52);
		gr.setColor(Color.BLUE);
		gr.fillRect(19, 79, (int) PlayerAnimater.mana, 51);
		
		gr.setColor(Color.BLACK);
		gr.drawRect(518, 18, (int) (DragonAnimatar.health+1), 52);
		gr.setColor(Color.RED);
		gr.fillRect(519, 19, (int) DragonAnimatar.health, 51);
		
		return gr;
	}
	
	public static ArrayList<Sprite> genScreen() {
		//byte[] pixels = ((DataBufferByte) screen.getRaster().getDataBuffer()).getData();
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		for(int x = 0; x< screen.getWidth();x++) {
			for(int y = 0;y < screen.getHeight();y++) {
				int rgb = screen.getRGB(x, y);
				int red = (rgb >> 16) & 0xFF;
				int green = (rgb >> 8) & 0xFF;
				int blue = rgb & 0xFF;

				switch(red) {
				case 0: sprites.add(Tiles.get(0));break;
				case 1: sprites.add(Tiles.get(1));break;
				case 2: sprites.add(Tiles.get(2));break;
				case 3: sprites.add(Tiles.get(3));break;
				case 4: sprites.add(Tiles.get(4));break;
				
				}
				
			}
			

		}
		
		
		return sprites;
	}
	
	public static Graphics drawTiles(Graphics gr, ArrayList<Sprite> sprites) {
		int counter = 0;
		for(int x = 0; x< Engine.width;x = x + 64) {
			for(int y = 0;y < Engine.height ;y = y + 64) {
				//System.out.println(x + " " + y);
				gr.drawImage(sprites.get(counter++).getImg(), x, y, null);
			}
		}
				
		return gr;
		
	}
	
	
	
	
	
	
}
