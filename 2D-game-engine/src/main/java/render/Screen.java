package main.java.render;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import main.java.shape.Rectangle;
import main.java.shape.Shape;

public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	public JFrame frame;
	public int[] pixels;
	
	public BufferedImage inBetween;
	
	public List<Shape> shapes = new ArrayList<Shape>();
	
	public Screen(JFrame frame, Dimension dimension) throws IOException {
		this.frame = frame;
		frame.setPreferredSize(dimension);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setTitle("Game");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.requestFocus();
		
		pixels = new int[getWidth()*getHeight()];
		inBetween = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
	}
	
	
	
	public void setSize(Dimension dimension) {
		frame.setPreferredSize(dimension);
	}
	
	public void setIcon(Image icon) {
		frame.setIconImage(icon);
	}
	
	public void setTitle(String title) {
		frame.setTitle(title);
	}
	
	public void enableFrame() {
		frame.setVisible(true);
	}
	
	public void setPixels() {
		for (int i = 0; i < shapes.size(); i++) {
			for (int j = 0; j < shapes.get(i).getTexture().getHeight(); j++) {
				for (int l = 0; l < shapes.get(i).getTexture().getWidth(); l++) {
					if (shapes.get(i).getTexture().getRGB(l, j) != 0xFF00FF && j*getWidth() + l < pixels.length) pixels[j*getWidth() + l] = shapes.get(i).getTexture().getRGB(l, j);
				}
			}
			shapes.get(i).setTexture(resize(shapes.get(i).getTexture(), shapes.get(i).getWidth(), shapes.get(i).getHeight()));
		}
		for (int i = 0; i < pixels.length; i++) {
			inBetween.setRGB(i % getWidth(), i / getWidth(), pixels[i]);
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		setPixels();
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(inBetween, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	public BufferedImage resize(BufferedImage img, int width, int height) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}
	
	public void addRect(int x, int y, int width, int height, BufferedImage texture) {
		this.shapes.add(new Rectangle(x, y, width, height, texture));
	}
	
	public void removeShape(int index) {
		this.shapes.remove(index);
	}
	
	public void changeItem(int index, int newValue, List<Integer> list) {
		list.set(index, newValue);
	}
	
	public void changeItem(int index, Image newValue, List<Image> list) {
		list.set(index, newValue);
	}
	
}
