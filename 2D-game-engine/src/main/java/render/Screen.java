package main.java.render;

import java.awt.Canvas;
import java.awt.Color;
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
import main.java.sprite.Sprite;

public class Screen extends Canvas {

	private static final long serialVersionUID = -7004570169397651722L;

	public JFrame frame;
	public int[] pixels;
	
	public BufferedImage inBetween;
	
	public static List<Shape> shapes = new ArrayList<Shape>();
	
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
		
		pixels = new int[(int)dimension.getWidth()*(int)dimension.getHeight()];
		inBetween = new BufferedImage((int)dimension.getWidth(), (int)dimension.getHeight(), BufferedImage.TYPE_INT_RGB);
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
		for (Shape shape : shapes) {
			for (int j = 0; j < shape.getSprite().getTexture().getHeight(); j++) {
				for (int l = 0; l < shape.getSprite().getTexture().getWidth(); l++) {
					if (l + shape.getX() < inBetween.getWidth() && j + shape.getY() < inBetween.getHeight() && j*getWidth() + l < pixels.length)
						if (shape.getSprite().getTexture().getRGB(l, j) != -65281) pixels[(j + shape.getY()) * inBetween.getWidth() + l + shape.getX()] = shape.getSprite().getTexture().getRGB(l, j);
						else pixels[(j + shape.getY()) * inBetween.getWidth() + l + shape.getX()] = 0;
				}
			}
		}
		
		for (int i = 0; i < pixels.length; i++) {
			inBetween.setRGB(i % inBetween.getHeight(), i / inBetween.getWidth(), pixels[i]);
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
	
	public void Rect(int x, int y, int width, int height, double rotation, Sprite sprite) {
		shapes.add(new Rectangle(x, y, width, height, rotation, new Sprite(Shape.rotate(Shape.resize(sprite.getTexture(), width, height), rotation))));
	}
	
	public void Rect(int x, int y, int width, int height, double rotation, Color colour) {
		BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = b.createGraphics();
		g2d.setColor(colour);
		g2d.fillRect(0, 0, b.getWidth(), b.getHeight());
		g2d.dispose();
		
		shapes.add(new Rectangle(x, y, width, height, rotation, new Sprite(b)));
	}
	
	public void removeShape(int index) {
		shapes.remove(index);
	}
	
	public void changeItem(int index, int newValue, List<Integer> list) {
		list.set(index, newValue);
	}
	
	public void changeItem(int index, Image newValue, List<Image> list) {
		list.set(index, newValue);
	}
	
}
