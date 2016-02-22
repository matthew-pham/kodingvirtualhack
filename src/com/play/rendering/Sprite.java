package com.play.rendering;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.imageio.ImageIO;

public class Sprite {

	private BufferedImage img;
	


	public BufferedImage getImg() {
		return img;
	}



	public void setImg(BufferedImage img) {
		this.img = img;
	}



	public Sprite init(final String path) {
		
		
		
		AccessController.doPrivileged(new PrivilegedAction() {

			@Override
			public Object run() {
				try {
					System.out.println((new File(path)).getCanonicalPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					File file = new File(path);
					img = ImageIO.read(file);
				} catch (IOException e) {
					System.err.println("IOException:");
					e.printStackTrace();
				}
				return null;
			}
           
        });
		
		
		
		
		
		return this;
		
		
	}








	

	
	
	
}
