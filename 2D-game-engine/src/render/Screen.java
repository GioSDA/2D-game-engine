package render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Screen {

	public Screen(JFrame frame, Dimension dimension) throws IOException {
		frame.setSize(dimension);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(ImageIO.read(new File("C:/Users/Giovanni.ClarescoInc-PC/git/2D-game-engine/2D-game-engine/res/images/GameIcon.png")));
		frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void render(JFrame frame, Graphics g, Image image) {
		
	}
	
	public void enableFrame(JFrame frame) {
		frame.setVisible(true);
	}
	
}
