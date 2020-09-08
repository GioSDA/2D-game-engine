package main.java.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** Keeps track of keyboard input. */
public class KeyboardInput implements KeyListener {

	/** Current keys being pressed. */
	public static boolean[] keys = new boolean[500];
	
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
