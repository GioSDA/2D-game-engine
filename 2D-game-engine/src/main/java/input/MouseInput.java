package main.java.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	public static boolean[] mouseButtons = new boolean[15];
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		mouseButtons[arg0.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mouseButtons[arg0.getButton()] = false;
	}

}
