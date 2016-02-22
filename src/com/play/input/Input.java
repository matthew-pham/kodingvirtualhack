package com.play.input;


import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.play.engine.Engine;

public class Input extends Thread implements KeyListener {
	
	private static ArrayList<Integer> keysPressed = new ArrayList<Integer>();

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(!keysPressed.contains(arg0.getKeyCode())) {
		keysPressed.add(arg0.getKeyCode());
		}
		System.out.println(keysPressed);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keysPressed.remove(keysPressed.indexOf(arg0.getKeyCode()));
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isPressed(int id) {
		return keysPressed.contains(id);
	}
	
	@Override
	public void run() {


		
	}

	
}
