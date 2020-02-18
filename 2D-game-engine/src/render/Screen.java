package render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	public Screen(JFrame frame, Dimension dimension, Image icon) throws IOException {
		frame.setPreferredSize(dimension);
		frame.add(new Canvas());
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon);
		frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
