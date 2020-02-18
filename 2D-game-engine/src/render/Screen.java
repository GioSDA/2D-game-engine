package render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	public Screen(JFrame frame, Dimension dimension) throws IOException {
		frame.setPreferredSize(dimension);
		frame.add(new Canvas());
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setIconImage(ImageIO.read(new File("C:/Users/Giovanni.ClarescoInc-PC/git/2D-game-engine/2D-game-engine/res/images/GameIcon.png")));
		frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void render(JFrame frame, Image image) {
		Graphics g = frame.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image,  0,  0, frame.getWidth(), frame.getHeight(), null);
	}
	
	public void enableFrame(JFrame frame) {
		frame.setVisible(true);
	}
	
	public void render(Image image) {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
}
